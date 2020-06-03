package com.dms.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dms.app.entity.SysUserTable;
import com.dms.app.vo.SysUserVo;

public interface SysUserService extends IService<SysUserTable>  {

    /**
     * 通过账号查询用户
     * @param username
     * @return
     */
    SysUserTable getUserByUserName(String username);


    //SysUserVo getUserById(String id);


    /**
     * 个性化验证登录
     * @param username 账号
     * @param rawPassword 原始密码
     * @return
     */
    boolean checkLogin(String username, String rawPassword) throws Exception;

    /**
     * 注册
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    boolean register(SysUserVo sysUserVo) throws Exception;

     /**
     * 更改用户
     * @param sysUserVo
     * @return
     * @throws Exception
     */
    boolean updateUserById(SysUserVo sysUserVo); 


    /**
     * 修改当前用户的信息，只能修改基本的信息，不能修改自己的角色
     * @param sysUserVo
     * @param newPassw
     * @return
     */
    boolean updateCurrentUser(SysUserVo sysUserVo) throws Exception ;


    /**
     * 查询用户模型
     * @param page
     * @param queryWrapper
     * @return
     */
    IPage<SysUserVo> getUserVoList(IPage<SysUserTable> page, SysUserTable sysUserTable);


    /**
     * 根据用户ID查询用户
     * @param id
     * @return
     */
    SysUserVo getUserById( String id);

}
