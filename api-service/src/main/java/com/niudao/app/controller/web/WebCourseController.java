package com.niudao.app.controller.web;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.Course;
import com.niudao.app.service.CourseService;
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
@RequestMapping("web/course")
public class WebCourseController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CourseService courseService;

    /**
     * 分页查询所有数据
     */
    @GetMapping
    public R selectAll(Page<Course> page,
                       @RequestParam(value = "courseCategoryId",required = false) String courseCategoryId,
                       @RequestParam(value = "courseTypeId",required = false)String courseTypeId,
                       @RequestParam(value = "courseKnowledgeList",required = false)List<String> courseKnowledgeList,
                       @RequestParam(value = "courseForPeopleList",required = false)List<String> courseForPeopleList,
                       @RequestParam(value = "keyword",required = false)String keyword,
                       @RequestParam(value = "orderType",required = false) Integer orderType) {
        //调用自定义的方法
        return success(this.courseService.getCourse(page,courseCategoryId,courseTypeId,courseKnowledgeList,courseForPeopleList,keyword,orderType));
    }

    /**
     * 查询关联数据
     */
    @GetMapping("ralationCourse")
    public R ralationCourse(Page<Course> page,
                       @RequestParam(value = "courseTypeId",required = false)String courseTypeId,
                       @RequestParam(value = "courseId",required = false)String courseId) {
        //调用自定义的方法
        return success(this.courseService.getRalationCourse(page,courseTypeId,courseId));
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

}