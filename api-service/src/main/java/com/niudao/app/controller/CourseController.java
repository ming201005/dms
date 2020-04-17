package com.niudao.app.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.Course;
import com.niudao.app.service.CourseService;
import com.niudao.app.vo.CourseVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Course)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@RestController
@RequestMapping("course")
public class CourseController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param course 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Course> page, Course course) {
        //调用自定义的方法
        R rs = success(this.courseService.getCourseList(page,course));
        System.out.println("rs = " + rs);
        return rs;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.courseService.getCourseById(id));
    }

    /**
     * 新增数据
     *
     * @param courseVo VO对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody CourseVo courseVo) {
        return success(this.courseService.saveOrUpdateData(courseVo));
    }

    /**
     * 修改数据
     *
     * @param courseVo VO对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody CourseVo courseVo) {
        return success(this.courseService.saveOrUpdateData(courseVo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.courseService.removeCourseByIds(idList));
    }
}