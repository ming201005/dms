package com.niudao.app.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * 销售模式
 */
public enum ProductSaleModelEnum implements IEnum<Integer> {

    SALE_ONE(1, "实物销售"),
    SALE_TWO(2, "预售模式");

    private int code;
    private String desc;

    ProductSaleModelEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public Integer getValue() {

     return this.code;
    }

    public String getDesc() {
        return desc;
    }

    public String toString(){
        return desc;
    }




}
