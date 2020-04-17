package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.CourseCategory;
import com.niudao.app.service.CourseCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (CourseCategory)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@RestController
@RequestMapping("courseCategory")
public class CourseCategoryController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseCategoryService courseCategoryService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param courseCategory 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CourseCategory> page, CourseCategory courseCategory) {
        return success(this.courseCategoryService.page(page, new QueryWrapper<>(courseCategory).orderByAsc("course_category_sort")));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.courseCategoryService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param courseCategory 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CourseCategory courseCategory) {
        return success(this.courseCategoryService.save(courseCategory));
    }

    /**
     * 修改数据
     *
     * @param courseCategory 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CourseCategory courseCategory) {
        return success(this.courseCategoryService.updateById(courseCategory));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.courseCategoryService.removeByIds(idList));
    }
}