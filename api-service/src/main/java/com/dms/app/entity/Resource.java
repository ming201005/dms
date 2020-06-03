package com.dms.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Resource)表实体类
 *
 * @author 
 * @since 2020-04-23 12:24:59
 */
@SuppressWarnings("serial")
public class Resource extends Model<Resource> {
    //唯一ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //文件类型ID-外键
    private Integer typeId;
    //文件名称
    private String resourceName;
    //物理视频上存储的文件名称
    private String pathResourceName;
    //上传时间
    private Date createTime;
    //文件大小（单位MB：9.35MB)
    private Double resourceSize;
    //文件后缀：doc、pdf、等
    private String fileSuffix;
    //文件状态，0：私有；1：公共
    private Integer resourceState;
    //文件上传人
    private String upUser;

    //描述
    private String des;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getPathResourceName() {
        return pathResourceName;
    }

    public void setPathResourceName(String pathResourceName) {
        this.pathResourceName = pathResourceName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(Double resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Integer getResourceState() {
        return resourceState;
    }

    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

    public String getUpUser() {
        return upUser;
    }

    public void setUpUser(String upUser) {
        this.upUser = upUser;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", resourceName='" + resourceName + '\'' +
                ", pathResourceName='" + pathResourceName + '\'' +
                ", createTime=" + createTime +
                ", resourceSize=" + resourceSize +
                ", fileSuffix='" + fileSuffix + '\'' +
                ", resourceState=" + resourceState +
                ", upUser='" + upUser + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}