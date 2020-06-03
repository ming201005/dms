package com.dms.app.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dms.app.entity.SysRoleTable;
import com.dms.app.entity.SysRoleUserTable;
import com.dms.app.vo.SysRoleAndPermissionVo;

/**
 * (SysRoleUserTable)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-08 23:03:14
 */
public interface SysRoleUserTableService extends IService<SysRoleUserTable> {

    /**
     * 批量保存角色-用户表
     * 该方法内有两个操作，先删除、后批量新增，因此存在事务控制
     * @param roleId
     * @param sysRoleAndPermissionVos
     * @return
     */
    boolean saveRoleUser(String roleId, SysRoleAndPermissionVo... sysRoleAndPermissionVos);

    /**
     * 根据用户ID，存储多个角色
     * @param userId
     * @param roles
     * @return
     */
    boolean saveUserRoles(String userId, List<SysRoleTable> roles);

    
}