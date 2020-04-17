package com.niudao.app.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (ProductUnit)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@SuppressWarnings("serial")
public class ProductUnit extends Model<ProductUnit> {
    //唯一ID
    private Integer id;
    //中文单位名称（如：千克）
    private String unitNameZh;
    //英文单位名称（如：kg）
    private String unitNameEn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnitNameZh() {
        return unitNameZh;
    }

    public void setUnitNameZh(String unitNameZh) {
        this.unitNameZh = unitNameZh;
    }

    public String getUnitNameEn() {
        return unitNameEn;
    }

    public void setUnitNameEn(String unitNameEn) {
        this.unitNameEn = unitNameEn;
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