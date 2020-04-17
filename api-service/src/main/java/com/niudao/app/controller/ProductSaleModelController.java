package com.niudao.app.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.niudao.app.enums.ProductSaleModelEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (ProductSaleModel)表控制层
 */
@RestController
@RequestMapping("productSaleModelEnum")
public class ProductSaleModelController {

    /**
     * 获取枚举中的所有key、value
     * @return
     */
    @GetMapping
    public R<List<Map<String,Object>>>  selectAll() {

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = null;

        ProductSaleModelEnum[] productSaleModelEnums = ProductSaleModelEnum.values ();
        for (ProductSaleModelEnum item : productSaleModelEnums) {
            map = new HashMap<> ();
            map.put ("value", item);
            map.put ("name", item.getDesc ());
            list.add (map);
        }
        return R.ok (list);
    }
}