package com.dms.app.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dms.app.entity.*;
import com.dms.app.vo.SysUserVo;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户Dao
 */
public interface SysUserMapper extends BaseMapper<SysUserTable> {

   /**
    * 查询用户模型
    * @param page
    * @param queryWrapper
    * @return
    */
   @Select("select \n"+
           " user_id as id, \n"+
           " user_name as name, \n"+
           " user_show as userShow ,\n"+
           " user_sex  as userSex,\n"+
           " user_type as userType, \n"+
           " organization_id as organizationId, \n"+
           " description as des \n"+
           " from sys_user_table ${ew.customSqlSegment} "
           )
   //映射配置
   @Results({
           @Result(column = "id",property = "id"),

           //查询组织 1对1配置
           @Result(column = "organizationId",property = "organization",
                   one = @One(select = "getOrganization",fetchType = FetchType.LAZY)
           ),
           //角色，1对N配置
           @Result(column = "id", property = "roleList",
                   many = @Many(select = "getRoleList",fetchType = FetchType.LAZY)
           )
   })
   IPage<SysUserVo> getUserVoList(@Param(Constants.WRAPPER) IPage<SysUserTable> page,
                                  @Param(Constants.WRAPPER) Wrapper<SysUserTable> queryWrapper);

   //组织
   @Select("select * from organization where id = #{organizationId}")
   Organization getOrganization(@Param("organizationId") Integer organizationId);

   //角色
   @Select("select  \n"+
          "  a.role_id,\n"+
          "  role_name \n"+
         " from sys_role_table a, sys_role_user_table b where a.role_id=b.role_id and b.user_id=#{id}")
   List<SysRoleTable> getRoleList(@Param("id") String id);
}
