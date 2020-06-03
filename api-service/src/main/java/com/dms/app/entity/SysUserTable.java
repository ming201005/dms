package com.dms.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (SysUserTable)表实体类
 *
 * @author 
 * @since 2020-04-22 15:34:02
 */
@SuppressWarnings("serial")
public class SysUserTable extends Model<SysUserTable> {
    //主键
    @TableId(type = IdType.UUID)
    private String userId;
    //登录账号
    private String userName;
    //姓名
    private String userShow;
    //用户密码-BCR算法加密
    private String passWord;
    //性别
    private String userSex;
    //用户类型：1-学生；2-非学生（泛指教师及工作人员）；
    private Integer userType;
    //状态
    private Integer state;
    //描述
    private String description;
    //组织，对应院系主键
    private Integer organizationId;

    public SysUserTable() {
    }

    public SysUserTable(String userId, String userName, String userShow, String passWord, String userSex, Integer userType, Integer state, String description, Integer organizationId) {
        this.userId = userId;
        this.userName = userName;
        this.userShow = userShow;
        this.passWord = passWord;
        this.userSex = userSex;
        this.userType = userType;
        this.state = state;
        this.description = description;
        this.organizationId = organizationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserShow() {
        return userShow;
    }

    public void setUserShow(String userShow) {
        this.userShow = userShow;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }
    
    
}