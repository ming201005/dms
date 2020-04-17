package com.niudao.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ProductTag)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@SuppressWarnings("serial")
public class ProductTag extends Model<ProductTag> {
    //唯一ID
    private Integer id;
    //产品标签名称【如：爆款、最爱、超喜欢、女神节热销品、熬夜最佳搭档零食】
    private String productTagName;
    
    private String productTagType;
    //排序
    private Integer productTagSort;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductTagName() {
        return productTagName;
    }

    public void setProductTagName(String productTagName) {
        this.productTagName = productTagName;
    }

    public String getProductTagType() {
        return productTagType;
    }

    public void setProductTagType(String productTagType) {
        this.productTagType = productTagType;
    }

    public Integer getProductTagSort() {
        return productTagSort;
    }

    public void setProductTagSort(Integer productTagSort) {
        this.productTagSort = productTagSort;
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