package com.dms.app.vo;


import com.dms.app.entity.Organization;
import com.dms.app.entity.SysRoleTable;

import java.util.List;

/**
 * 用户vo
 */
public class SysUserVo {

    String id = null;
    String name = null;//登录账号
    String passw = null;//登录密码
    String userShow = null;  //显示名称
    String userSex = "男";//性别
    Integer userType = null;//用户类型，1：学生；2：非学生

    Organization organization = null;//院系

    String des = null;//描述
    //角色
    List<SysRoleTable> roleList = null;

    //修改用户需要
    String newPassw = null;

    public SysUserVo() {
    }

    public SysUserVo(String id, String name, String passw, String userShow, String userSex, Integer userType, Organization organization, String des, List<SysRoleTable> roleList) {
        this.id = id;
        this.name = name;
        this.passw = passw;
        this.userShow = userShow;
        this.userSex = userSex;
        this.userType = userType;
        this.organization = organization;
        this.des = des;
        this.roleList = roleList;
    }

    public String getNewPassw() {
        return newPassw;
    }

    public void setNewPassw(String newPassw) {
        this.newPassw = newPassw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getUserShow() {
        return userShow;
    }

    public void setUserShow(String userShow) {
        this.userShow = userShow;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<SysRoleTable> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRoleTable> roleList) {
        this.roleList = roleList;
    }
}
