package com.dms.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dms.app.dao.SysRoleUserTableDao;
import com.dms.app.entity.SysRoleTable;
import com.dms.app.entity.SysRoleUserTable;
import com.dms.app.service.SysRoleUserTableService;
import com.dms.app.vo.SysRoleAndPermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (SysRoleUserTable)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-08 23:03:14
 */
@Service("sysRoleUserTableService")
public class SysRoleUserTableServiceImpl extends ServiceImpl<SysRoleUserTableDao, SysRoleUserTable> implements SysRoleUserTableService {

    /**
     * 批量保存角色-用户表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    @Override
    @Transactional
    public   boolean saveRoleUser(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos){

        System.out.println("roleId = " + roleId);

        //先删除数据
        this.delRoleId(roleId);
        //
        if(sysRoleAndPermissionVos !=null) {
            Set<SysRoleUserTable> set = new HashSet<>();
            SysRoleUserTable roleUser = null;
            for (SysRoleAndPermissionVo roleVo : sysRoleAndPermissionVos) {
                roleUser = new SysRoleUserTable();
                //存储roleID和userID到多对对的中间表
                roleUser.setRoleId(roleVo.getRoleId());
                roleUser.setUserId(roleVo.getId());
                set.add(roleUser);
            }
            System.out.println("set = " + set);
            //再批量保存
            return this.saveBatch(set);
        }
        return  false;
    }



    /**
     * 根据用户ID，存储多个角色
     * @param userId
     * @param roles
     * @return
     */
    @Override
    @Transactional
    public boolean saveUserRoles(String userId, List<SysRoleTable> roles){
        
        System.out.println("userId = " + userId);

        //先删除数据
        this.removeRolesByUserId(userId);
        //
        if(roles != null) {
            Set<SysRoleUserTable> set = new HashSet<>();
            SysRoleUserTable roleUser = null;
            for (SysRoleTable item : roles) {
                roleUser = new SysRoleUserTable();
                //存储roleID和userID到多对对的中间表
                roleUser.setUserId(userId);
                roleUser.setRoleId(item.getRoleId());
                //
                set.add(roleUser);
            }
            System.out.println("saveUserRoles set = " + set);
            //再批量保存
            return this.saveBatch(set);
        }
        return  false;
    }



    /**
     * 根据RoleId删除
     * @param roleId
     * @return
     */
    private boolean delRoleId(String roleId) {
        LambdaQueryWrapper<SysRoleUserTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleUserTable::getRoleId,roleId);
        return this.remove(lambdaQueryWrapper);
    }

    /**
     * 根据用户ID删除用户\角色表
     * @param userId
     * @return
     */
    private boolean removeRolesByUserId(String userId){
        LambdaQueryWrapper<SysRoleUserTable> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysRoleUserTable::getUserId,userId);
        return this.remove(lambdaQueryWrapper);
    }
}