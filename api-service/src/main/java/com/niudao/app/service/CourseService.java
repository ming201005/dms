package com.niudao.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.Course;
import com.niudao.app.vo.CourseVo;
import com.niudao.app.vo.WebCourseVo;

import java.io.Serializable;
import java.util.List;

/**
 * (Course)表服务接口
 * 该类由EasyCode工具生成
 *
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseService extends IService<Course> {

    /**
     * 查询列表
     *
     * @param page   分页对象
     * @param course 课程对象
     * @return 返回分页后的对象
     */
     IPage<CourseVo> getCourseList(Page<Course> page, Course course) ;

    /**
     * web端分页搜索课程信息
     *
     * @param page                分页对象
     * @param courseCategoryId    分类ID
     * @param courseTypeId        类别ID
     * @param courseKnowledgeList 知识点，多个
     * @param courseForPeopleList 适用人群 多个
     * @param keyword             搜索关键字，主要匹配标题
     * @param orderType           排序方式  不等于1： 默认按照时间排序
     *                            等于1：按照学习人数排序
     * @return
     */
    IPage<WebCourseVo> getCourse(Page<Course> page,
                                 String courseCategoryId,
                                 String courseTypeId,
                                 List<String> courseKnowledgeList,
                                 List<String> courseForPeopleList,
                                 String keyword,
                                 Integer orderType);

    /**
     * 根据id和类型，查询相关的课程
     * @param page
     * @param courseTypeId
     * @param courseId
     * @return
     */
   IPage<WebCourseVo>  getRalationCourse(Page<Course> page,
                                                 String courseTypeId,
                                                 String courseId);

    /**
     * 根据ID查询课程
     *
     * @param id 课程id
     * @return 返回课程模型
     */
    CourseVo getCourseById(Serializable id);


    /**
     * 保存或更新课程信息
     *
     * @param courseVo
     * @return
     */
    CourseVo saveOrUpdateData(CourseVo courseVo);

    /**
     * 根据ID删除课程信息，包含其子表的相关信息
     *
     * @param idList
     * @return
     */
    boolean removeCourseByIds(List<String> idList);
}