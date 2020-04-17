package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.CourseComment;
import com.niudao.app.service.CourseCommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (CourseComment)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@RestController
@RequestMapping("courseComment")
public class CourseCommentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseCommentService courseCommentService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param courseComment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CourseComment> page, CourseComment courseComment) {
        return success(this.courseCommentService.page(page, new QueryWrapper<>(courseComment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.courseCommentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param courseComment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CourseComment courseComment) {
        return success(this.courseCommentService.save(courseComment));
    }

    /**
     * 修改数据
     *
     * @param courseComment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CourseComment courseComment) {
        return success(this.courseCommentService.updateById(courseComment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.courseCommentService.removeByIds(idList));
    }
}