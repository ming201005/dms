package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.CourseAndPeople;
import com.niudao.app.service.CourseAndPeopleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (CourseAndPeople)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@RestController
@RequestMapping("courseAndPeople")
public class CourseAndPeopleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseAndPeopleService courseAndPeopleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param courseAndPeople 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<CourseAndPeople> page, CourseAndPeople courseAndPeople) {
        return success(this.courseAndPeopleService.page(page, new QueryWrapper<>(courseAndPeople)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.courseAndPeopleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param courseAndPeople 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CourseAndPeople courseAndPeople) {
        return success(this.courseAndPeopleService.save(courseAndPeople));
    }

    /**
     * 修改数据
     *
     * @param courseAndPeople 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CourseAndPeople courseAndPeople) {
        return success(this.courseAndPeopleService.updateById(courseAndPeople));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.courseAndPeopleService.removeByIds(idList));
    }
}