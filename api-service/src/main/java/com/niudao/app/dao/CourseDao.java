package com.niudao.app.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.niudao.app.entity.*;
import com.niudao.app.vo.CourseVo;
import com.niudao.app.vo.WebCourseVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * (Course)表数据库访问层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseDao extends BaseMapper<Course> {

     /**
      * 查询课程模型
      * @param page
      * @param queryWrapper
      * @return
      */
     @Select("select * from course ${ew.customSqlSegment} ")
     //映射配置
     @Results({
             @Result(id = true,column = "course_id",property = "courseId"),
             @Result(column = "course_category_id",property = "courseCategoryId"),
             @Result(column = "course_type_id",property = "courseTypeId"),

             //查询分类 1对1配置
             @Result(column = "course_category_id",property = "courseCategory",
                     one = @One(select = "getCourseCategory",fetchType = FetchType.LAZY)
             ),

             //查询类别 1对1配置
             @Result(column = "course_type_id",property = "courseType",
                     one = @One(select = "getCourseType",fetchType = FetchType.LAZY)
             ),

             //章节，1对N配置
             @Result(column = "course_id", property = "courseChapterList",
                     many = @Many(select = "getCourseChapterList",fetchType = FetchType.LAZY)
             ),

             //涉及知识点，1对N配置
             @Result(column = "course_id", property = "courseKnowledgeList",
                     many = @Many(select = "getCourseKnowledgeList",fetchType = FetchType.LAZY)
             ),

             //适用人群，1对N配置
             @Result(column = "course_id", property = "courseForPeopleList",
                     many = @Many(select = "getCourseForPeopleList",fetchType = FetchType.LAZY)
             )
     })
     IPage<CourseVo> getCourseList(@Param(Constants.WRAPPER) IPage<Course> page,
                                   @Param(Constants.WRAPPER) Wrapper<Course> queryWrapper);

     //查询分类
     @Select("select * from course_category where course_category_id = #{courseCategoryId} order by course_category_sort asc")
     CourseCategory getCourseCategory(@Param("courseCategoryId") String courseCategoryId);

     //查询类别
     @Select("select * from course_type where course_type_id = #{courseTypeId} order by course_type_sort asc")
     CourseType getCourseType(@Param("courseTypeId") String courseTypeId);

     //课程清单（视频，多份）
     @Select("select * from course_chapter where course_id=#{courseId} order by course_chapter_sort asc")
     List<CourseChapter> getCourseChapterList(@Param("courseId") String courseId);

     //对应的知识点
     @Select("select b.id,b.course_id,a.* from course_knowledge a,course_and_knowledge b \n"+
             " where b.course_knowledge_id=a.course_knowledge_id and b.course_id=#{courseId} order by a.course_knowledge_sort asc")
     List<CourseKnowledge> getCourseKnowledgeList(@Param("courseId") String courseId);

     //适用人群
     @Select("select b.id,b.course_id,a.* from course_for_people a,course_and_people b \n"+
             " where b.course_for_people_id=a.course_for_people_id and b.course_id=#{courseId} order by a.course_for_people_sort asc")
     List<CourseForPeople> getCourseForPeopleList(@Param("courseId") String courseId);


    /**
     * web端页面需检索的功能
     * @param page
     * @param queryWrapper
     * @return
     */
     @Select("SELECT " +
             "    a.course_id," +
             "    d.course_category_name," +
             "    e.course_type_name," +
             "    a.course_name," +
             "    a.course_img," +
             "    a.price," +
             "    a.study_number," +
             "    a.create_time " +
             "FROM course a " +
             "left join course_and_knowledge b on b.course_id = a.course_id " +
             "left join course_and_people c  on c.course_id = a.course_id " +
             "left join course_category d on d.course_category_id = a.course_category_id " +
             "left join course_type e on e.course_type_id = a.course_type_id " +
             " ${ew.customSqlSegment} ")
     IPage<WebCourseVo> getCourse(@Param(Constants.WRAPPER) IPage<Course> page, @Param(Constants.WRAPPER) Wrapper queryWrapper);
}