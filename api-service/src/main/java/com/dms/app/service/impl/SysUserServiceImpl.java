package com.dms.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dms.app.components.BCryptPasswordEncoderUtil;
import com.dms.app.dao.SysRoleTableDao;
import com.dms.app.dao.SysUserMapper;
import com.dms.app.entity.Organization;
import com.dms.app.entity.SysRoleTable;
import com.dms.app.entity.SysUserTable;
import com.dms.app.service.OrganizationService;
import com.dms.app.service.SysRoleUserTableService;
import com.dms.app.service.SysUserService;
import com.dms.app.service.auth.AuthUser;
import com.dms.app.service.auth.AuthUserDetailsServiceImpl;
import com.dms.app.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户服务
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserTable> implements SysUserService {

    // 加密
    @Autowired
    BCryptPasswordEncoderUtil bCryptPasswordEncoderUtil;

    // 角色
    @Autowired
    SysRoleTableDao sysRoleTableDao;

    // 用户-角色-中间表（多对多关联的表）
    @Autowired
    SysRoleUserTableService sysRoleUserTableService;

    @Autowired
    AuthUserDetailsServiceImpl authUserDetailsServiceImpl;

    // 组织
    @Autowired
    OrganizationService organizationService;

    // 用户激活状态
    private static final int USER_STATE = 1;

    /**
     * 查询用户模型
     * 
     * @param page
     * @param sysUserTable
     * @return
     */
    @Override
    public IPage<SysUserVo> getUserVoList(final IPage<SysUserTable> page, final SysUserTable sysUserTable) {
        //
        final QueryWrapper<SysUserTable> queryWrapper = new QueryWrapper<>();
        if (sysUserTable != null) {
            // 组织不可为空
            queryWrapper.eq(StringUtils.checkValNotNull(sysUserTable.getOrganizationId()), "organization_id",
                    sysUserTable.getOrganizationId());
            queryWrapper.eq(StringUtils.checkValNotNull(sysUserTable.getUserId()), "user_id", sysUserTable.getUserId());
        }
        return this.baseMapper.getUserVoList(page, queryWrapper);
    }

    /**
     * 通过账号查询用户
     * 
     * @param username
     * @return
     */
    @Override
    public SysUserTable getUserByUserName(final String username) {

        //MP  : mybaits Plus
        final LambdaQueryWrapper<SysUserTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 查询条件：全匹配账号名，和状态为1的账号
        lambdaQueryWrapper.eq(SysUserTable::getUserName, username).eq(SysUserTable::getState, USER_STATE);

        // 用getOne查询一个对象出来
        final SysUserTable user = this.getOne(lambdaQueryWrapper);

        return user;
    }

    @Override
    @Transactional
    public SysUserVo getUserById(final String id) {
        // 得到用户信息
        final SysUserTable sysUser = this.getById(id);

        // 院系
        final Organization organization = this.organizationService.getById(sysUser.getOrganizationId());

        // 根据用户找角色
        final List<SysRoleTable> roles = sysRoleTableDao.getRolesByUserId(sysUser.getUserId());

        // po to vo .不能返回密码
        final SysUserVo vo = new SysUserVo(sysUser.getUserId(), sysUser.getUserName(), null, sysUser.getUserShow(),
                sysUser.getUserSex(), sysUser.getUserType(), organization, sysUser.getDescription(), roles);

        return vo;
    }

    /**
     * 个性化验证登录
     * 
     * @param username    账号
     * @param rawPassword 原始密码
     * @return
     */
    @Override
    public boolean checkLogin(final String username, final String rawPassword) throws Exception {

        final SysUserTable userEntity = this.getUserByUserName(username);
       
        System.out.println("userEntity = " + userEntity);

        if (userEntity == null) {
            // System.out.println("checkLogin--------->账号不存在，请重新尝试！");
            // 设置友好提示
            throw new Exception("账号不存在，请重新尝试！");
        } else {
            // 加密的密码
            final String encodedPassword = userEntity.getPassWord();
            // 和加密后的密码进行比配
            if (!bCryptPasswordEncoderUtil.matches(rawPassword, encodedPassword)) {
                // System.out.println("checkLogin--------->密码不正确！");
                // 设置友好提示
    
                throw new Exception("密码不正确！");
            } else {
                return true;
            }
        }
    }

    /**
     * 注册(新增用户)
     * 
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public boolean register(final SysUserVo sysUserVo) throws Exception {
        if (sysUserVo != null) {
            final SysUserTable f = this.getUserByUserName(sysUserVo.getName());
            if (f != null) {
                throw new Exception("这个用户已经存在，不能重复。");
            }
            // 1. 保存主表信息
            SysUserTable user = this.voToPo(sysUserVo);
            this.save(user);
            // 2. 添加角色
            // 在添加
            this.sysRoleUserTableService.saveUserRoles(user.getUserId(), sysUserVo.getRoleList());
            // 返回
            return true;
        } else {
            throw new Exception("错误消息：用户对象为空！");
        }
    }

    /**
     * 更改用户，是高级管理人员修改用户信息、角色信息。
     * 
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public boolean updateUserById(final SysUserVo sysUserVo) {
        if (sysUserVo != null) {
            // 转换
            SysUserTable user = this.voToPo(sysUserVo);
            // 不允许修改账号
            user.setUserName(null);
            // 修改
            this.updateById(user);
            // 2. 添加角色
            // 在添加
            this.sysRoleUserTableService.saveUserRoles(user.getUserId(), sysUserVo.getRoleList());
            // 返回
            return true;
        }
        return false;
    }

    /**
     * 修改当前用户的信息，只能修改基本的信息，不能修改自己的角色
     * 
     * @param sysUserVo
     * @return
     */
    @Override
    public boolean updateCurrentUser(SysUserVo sysUserVo) throws Exception {
        // 得到当前登录人
        AuthUser user = authUserDetailsServiceImpl.getCurrentUser();
        // 通过在服务端判断修改的用户信息是否是当前登录的用户信息。
        // 进行服务端保护
        if (user.getUsername().equals(sysUserVo.getName())) {
            // 检查旧密码是否正确
            boolean f = this.checkLogin(sysUserVo.getName(), sysUserVo.getPassw());
            if (f) {
                //新密码加密
                SysUserTable sysUser = new SysUserTable();
                sysUser.setPassWord(bCryptPasswordEncoderUtil.encode(sysUserVo.getNewPassw()));

                //设置更新条件
                LambdaUpdateWrapper<SysUserTable> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper.eq(SysUserTable::getUserName, user.getUsername());

                //更新
                return this.update(sysUser, updateWrapper);
            }else {
                throw new Exception("旧密码不对！");
            }
        } 
        return false;
    }



    /**
     * VO到PO的转换
     * 
     * @param vo
     * @return
     */
    private SysUserTable voToPo(final SysUserVo vo) {
        final SysUserTable po = new SysUserTable();
        if(vo !=null) {
            //id
            po.setUserId(vo.getId());
            //name
            po.setUserName(vo.getName());

            //如果密码为空，就不加密，不对密码进行修改转换
            if(vo.getPassw() != null) {
                //对密码进行加密
                po.setPassWord(bCryptPasswordEncoderUtil.encode(vo.getPassw()));
            }
            //show name
            po.setUserShow(vo.getUserShow());
            //set
            po.setUserSex(vo.getUserSex());
            //type
            po.setUserType(vo.getUserType());
            //des
            po.setDescription(vo.getDes());
            //organization ID
            po.setOrganizationId(vo.getOrganization().getId());

            //设置状态为1
            po.setState(USER_STATE);
        }
        return po;
    }
}
