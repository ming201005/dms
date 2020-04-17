package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * (Resource)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@SuppressWarnings("serial")
public class Resource extends Model<Resource> {
    //唯一ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //资源类型ID-外键
    private Integer typeId;
    //资源名称（URL地址）
    private String resourceName;
    //上传时间
    private Date createTime;
    //资源大小（单位MB：9.35MB)
    private Double resourceSize;
    //资源状态
    private Integer resourceState;


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

    public Integer getResourceState() {
        return resourceState;
    }

    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
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
    }