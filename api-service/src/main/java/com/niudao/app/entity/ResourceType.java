package com.niudao.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ResourceType)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@SuppressWarnings("serial")
public class ResourceType extends Model<ResourceType> {
    
    private Integer id;
    //资源类型名称
    private String resourceTypeName;
    //排序
    private Integer resourceTypeSort;
    //资源分类【1：图片，2：视频；3：压缩文件；4：其他】
    private String resourceGroup;


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

    public String getResourceGroup() {
        return resourceGroup;
    }

    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
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