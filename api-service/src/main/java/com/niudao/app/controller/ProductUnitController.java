package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.ProductUnit;
import com.niudao.app.service.ProductUnitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (ProductUnit)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@RestController
@RequestMapping("productUnit")
public class ProductUnitController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ProductUnitService productUnitService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param productUnit 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ProductUnit> page, ProductUnit productUnit) {
        return success(this.productUnitService.page(page, new QueryWrapper<>(productUnit)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.productUnitService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param productUnit 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ProductUnit productUnit) {
        return success(this.productUnitService.save(productUnit));
    }

    /**
     * 修改数据
     *
     * @param productUnit 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ProductUnit productUnit) {
        return success(this.productUnitService.updateById(productUnit));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.productUnitService.removeByIds(idList));
    }
}