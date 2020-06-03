package com.dms.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (ResourceType)表实体类
 *
 * @author 
 * @since 2020-04-21 19:51:54
 */
@SuppressWarnings("serial")
public class ResourceType extends Model<ResourceType> {
    @TableId(type = IdType.AUTO)
    private Integer id;
    //资源类型名称
    private String resourceTypeName;
    //排序
    private Integer resourceTypeSort;
    //描述
    private String resourceDes;
    //组织，对应院系主键
    private Integer organizationId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    public Integer getResourceTypeSort() {
        return resourceTypeSort;
    }

    public void setResourceTypeSort(Integer resourceTypeSort) {
        this.resourceTypeSort = resourceTypeSort;
    }

    public String getResourceDes() {
        return resourceDes;
    }

    public void setResourceDes(String resourceDes) {
        this.resourceDes = resourceDes;
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
        return this.id;
    }

    @Override
    public String toString() {
        return "ResourceType{" +
                "id=" + id +
                ", resourceTypeName='" + resourceTypeName + '\'' +
                ", resourceTypeSort=" + resourceTypeSort +
                ", resourceDes='" + resourceDes + '\'' +
                ", organizationId=" + organizationId +
                '}';
    }
}