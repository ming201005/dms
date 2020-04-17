package com.niudao.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ProductAttributes)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@SuppressWarnings("serial")
public class ProductAttributes extends Model<ProductAttributes> {
    //商品属性ID
    private Integer id;
    //商品属性名称
    private String productAttributesName;
    //排序
    private Integer productAttributesSort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductAttributesName() {
        return productAttributesName;
    }

    public void setProductAttributesName(String productAttributesName) {
        this.productAttributesName = productAttributesName;
    }

    public Integer getProductAttributesSort() {
        return productAttributesSort;
    }

    public void setProductAttributesSort(Integer productAttributesSort) {
        this.productAttributesSort = productAttributesSort;
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