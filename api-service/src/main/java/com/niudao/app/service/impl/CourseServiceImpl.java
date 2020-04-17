package com.niudao.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niudao.app.dao.CourseDao;
import com.niudao.app.entity.Course;
import com.niudao.app.service.CourseAndKnowledgeService;
import com.niudao.app.service.CourseAndPeopleService;
import com.niudao.app.service.CourseChapterService;
import com.niudao.app.service.CourseService;
import com.niudao.app.vo.CourseVo;
import com.niudao.app.vo.WebCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * (Course)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements CourseService {

    @Autowired
    private CourseChapterService courseChapterService;

    @Autowired
    CourseAndKnowledgeService courseAndKnowledgeService;

    @Autowired
    CourseAndPeopleService courseAndPeopleService;

    /**
     * 分页搜索课程信息
     * @param page 分页对象
     * @param course
     * @return
     */
    @Override
    public IPage<CourseVo> getCourseList(Page<Course> page, Course course) {
        if(page == null) page = new Page<>();
        //创建查询条件对象
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        //按类型搜索
        queryWrapper.eq(StringUtils.isNotEmpty(course.getCourseTypeId()),"course_type_id",course.getCourseTypeId());
        //按分类搜索
        queryWrapper.eq(StringUtils.isNotEmpty(course.getCourseCategoryId()),"course_category_id",course.getCourseCategoryId());
        //模糊搜索
        queryWrapper.like(StringUtils.isNotEmpty(course.getCourseName()),"course_name",course.getCourseName());
        //根据时间字段排序
        queryWrapper.orderByDesc("create_time");
        //调用dao层的方法
        return this.baseMapper.getCourseList(page,queryWrapper);
    }

    /**
     *  web端分页搜索课程信息
     * @param page 分页对象
     * @param courseCategoryId 分类ID
     * @param courseTypeId 类别ID
     * @param courseKnowledgeList 知识点，多个
     * @param courseForPeopleList 适用人群 多个
     * @param keyword 搜索关键字，主要匹配标题
     * @param orderType 排序方式  不等于1： 默认按照时间排序
     *                  等于1：按照学习人数排序
     * @return
     */
    @Override
    public IPage<WebCourseVo>  getCourse(Page<Course> page,
                                         String courseCategoryId,
                                         String courseTypeId,
                                         List<String> courseKnowledgeList,
                                         List<String> courseForPeopleList,
                                         String keyword,
                                         Integer orderType) {
        String fName = (orderType == null || orderType !=1)? "a.create_time" : "a.study_number";

        if(page == null) page = new Page<>();
        //创建查询条件对象
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper
                //按分类搜索
                .eq(StringUtils.isNotEmpty(courseCategoryId),"a.course_category_id",courseCategoryId)
                //按类型搜索
                .eq(StringUtils.isNotEmpty(courseTypeId),"a.course_type_id",courseTypeId)
                //匹配知识点
                .in(StringUtils.checkValNotNull(courseKnowledgeList),"b.course_knowledge_id",courseKnowledgeList)
                //匹配适用人群
                .in(StringUtils.checkValNotNull(courseForPeopleList),"c.course_for_people_id",courseForPeopleList)
                //模糊搜索,这里可以扩展成匹配所有字段如： and（course_name like xxxx or b.course_knowledge_name like xxxx）
                //这样可以做成类似全文检索。
                //如果数据量非常大，全文检索最好使用ElasticSearch做查询。效率会高很多。
                 .like(StringUtils.isNotEmpty(keyword),"a.course_name",keyword)
                //根据时间字段排序
                .orderByDesc(fName);
        queryWrapper.groupBy("a.course_id");
        //调用dao层的方法
        return this.baseMapper.getCourse(page,queryWrapper);
    }

    /**
     * 根据id和类型，查询相关的课程
     * @param page
     * @param courseTypeId
     * @param courseId
     * @return
     */
    @Override
    public IPage<WebCourseVo>  getRalationCourse(Page<Course> page,
                                                 String courseTypeId,
                                                 String courseId) {
        String fName = "a.study_number";

        if(page == null) page = new Page<>();
        //创建查询条件对象
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper
                //按类型搜索
                .eq(StringUtils.isNotEmpty(courseTypeId),"a.course_type_id",courseTypeId)
                //courseId
                .ne(StringUtils.isNotEmpty(courseId),"a.course_id",courseId)
                //根据时间字段排序
                .orderByDesc(fName);
        queryWrapper.groupBy("a.course_id");
        //调用dao层的方法
        return this.baseMapper.getCourse(page,queryWrapper);
    }


    /**
     * 根据ID取结果
     * @param id
     * @return
     */
    @Override
    public CourseVo getCourseById(Serializable id) {
        Course course = new Course();
        course.setCourseId((String)id);
        //创建查询条件对象
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(course.getCourseId()),"course_id",course.getCourseId());

        //调用dao层的方法
        IPage<CourseVo> page = this.baseMapper.getCourseList(new Page(1,1),queryWrapper);
        List<CourseVo> list = page.getRecords();

        //返回VO模型
        return (list !=null && list.size()>0) ? list.get(0): null;
    }


    /**
     * 新增或更改数据，此方法内有事务操作
     * @param courseVo
     * @return
     */
    @Override
    @Transactional
    public  CourseVo saveOrUpdateData(CourseVo courseVo) {
        //1、===============保存或更新课程表=====================
        //转换对象
        Course course = this.voToDo(courseVo);
        //如果没有ID，则保存新增的信息
        if(StringUtils.isEmpty(course.getCourseId())) {
            //保存主表数据。
            this.save(course);
        }else {
            //更新主表数据。
            this.updateById(course);
        }

        //上一步保存的主表，且course中的ID从生成主键策略中返回了值。
        //2、===============保存知识点中间表=======================
        this.courseAndKnowledgeService.saveBatchKnowledgeList(courseVo,course.getCourseId());

        //3、===============保存适用人群中间表=====================
        this.courseAndPeopleService.saveBatchCourseAndPeopleList(courseVo,course.getCourseId());

        //4、===============保存章节表=============================
        this.courseChapterService.saveBatchChapterList(courseVo,course.getCourseId());

        //5、===============重新返回Vo对象=============================
        //把保存之后生成的课程ID赋值给VO，并返回。
        courseVo.setCourseId(course.getCourseId());
        //返回VO模型
        return courseVo;
    }



    /**
     * 删除
     * @param idList
     * @return
     */
    @Override
    @Transactional
    public boolean removeCourseByIds(List<String> idList){
        String[] courseIds = listToStringArray(idList);
        //先删除子表,即视频表
        this.courseChapterService.deleteCourseChapters(courseIds);
        //TODO 其他的子表

        //在删除主表
        this.removeByIds(idList);

        return  true;
    }

    /**
     *
     * @param idList
     * @return
     */
    private String[] listToStringArray(List<String> idList) {
        if(idList !=null && idList.size()>0) {
            String[] courseIds = new String[idList.size()];
            for (int i = 0; i < idList.size(); i++) {
                courseIds[i] = idList.get(i);
            }
            return courseIds;
        }
        return null;
    }



    /**
     * vo转DO
     * @param courseVo
     * @return
     */
    private Course voToDo(CourseVo courseVo) {
        Course course = new Course();
        //ID
        course.setCourseId(courseVo.getCourseId());
        //其他属性
        course.setCourseCategoryId(courseVo.getCourseCategoryId());
        course.setCourseTypeId(courseVo.getCourseTypeId());
        course.setCourseName(courseVo.getCourseName());
        course.setCourseDes(courseVo.getCourseDes());
        course.setCourseImg(courseVo.getCourseImg());
        //返回对象
        return  course;
    }
}