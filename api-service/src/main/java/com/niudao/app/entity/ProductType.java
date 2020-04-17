package com.niudao.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ProductType)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@SuppressWarnings("serial")
public class ProductType extends Model<ProductType> {
    //唯一ID
    private Integer id;
    //商品分类名称
    private String productTypeName;
    //父节点ID（如果是顶级则是0）
    private Integer productTypePerentId;
    //排序
    private Integer productTypeSort;
    //状态（1：可用；0：不可用；）
    private Integer productTypeState;
    //分类图片【可以带图片】
    private Integer productTypeImgId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Integer getProductTypePerentId() {
        return productTypePerentId;
    }

    public void setProductTypePerentId(Integer productTypePerentId) {
        this.productTypePerentId = productTypePerentId;
    }

    public Integer getProductTypeSort() {
        return productTypeSort;
    }

    public void setProductTypeSort(Integer productTypeSort) {
        this.productTypeSort = productTypeSort;
    }

    public Integer getProductTypeState() {
        return productTypeState;
    }

    public void setProductTypeState(Integer productTypeState) {
        this.productTypeState = productTypeState;
    }

    public Integer getProductTypeImgId() {
        return productTypeImgId;
    }

    public void setProductTypeImgId(Integer productTypeImgId) {
        this.productTypeImgId = productTypeImgId;
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