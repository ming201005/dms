package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.Product;
import com.niudao.app.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (Product)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@RestController
@RequestMapping("product")
public class ProductController extends ApiController {

    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;


    /**
     * 商品分页查询（多表关联查询）
     * @param page
     * @param searchModel
     * @return
     */
    @GetMapping("list")
    public R selectList(Product searchModel, Page<Map<String,Object>> page) {
        return  success (productService.getList (page,searchModel));
    }


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param product 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Product> page, Product product) {
        return success(this.productService.page(page, new QueryWrapper<>(product)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.productService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param product 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Product product) {
        boolean rs = this.productService.save(product);
        return success(rs ? product:null);
    }

    /**
     * 修改数据
     *
     * @param product 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Product product) {
        boolean rs = this.productService.updateById(product);
        return success(rs ? product : null );
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.productService.removeByIds(idList));
    }
}