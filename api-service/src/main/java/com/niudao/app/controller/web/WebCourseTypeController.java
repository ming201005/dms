package com.niudao.app.controller.web;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.CourseType;
import com.niudao.app.service.CourseTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (CourseType)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@RestController
@RequestMapping("web/courseType")
public class WebCourseTypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseTypeService courseTypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param courseType 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CourseType> page, CourseType courseType) {
        return success(this.courseTypeService.page(page, new QueryWrapper<>(courseType).orderByAsc("course_type_sort")));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.courseTypeService.getById(id));
    }
}