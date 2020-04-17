package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.ProductReview;
import com.niudao.app.service.ProductReviewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (ProductReview)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:38
 */
@RestController
@RequestMapping("productReview")
public class ProductReviewController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ProductReviewService productReviewService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param productReview 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ProductReview> page, ProductReview productReview) {
        return success(this.productReviewService.page(page, new QueryWrapper<>(productReview)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.productReviewService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param productReview 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ProductReview productReview) {
        return success(this.productReviewService.save(productReview));
    }

    /**
     * 修改数据
     *
     * @param productReview 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ProductReview productReview) {
        return success(this.productReviewService.updateById(productReview));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.productReviewService.removeByIds(idList));
    }
}