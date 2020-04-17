package com.niudao.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.Product;


import java.util.Map;

/**
 * (Product)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
public interface ProductService extends IService<Product> {

    /**
     * 商品列表（后台管理列表，带搜索）
     * @param searchModel
     * @return
     */
    Page<Map<String,Object>> getList(Page<Map<String, Object>> page, Product searchModel);
}