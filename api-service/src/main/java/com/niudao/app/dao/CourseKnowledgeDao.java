package com.niudao.app.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.niudao.app.entity.CourseKnowledge;
import com.niudao.app.vo.CourseKnowledgeVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * (CourseKnowledge)表数据库访问层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseKnowledgeDao extends BaseMapper<CourseKnowledge> {

    @Select("select "
            +" a.*,b.course_category_name "
            +" from  course_knowledge a "
            +" left join course_category b "
            +" on b.course_category_id = a.course_category_id"
            +" ${ew.customSqlSegment}")
    IPage<CourseKnowledgeVo> getCourseKnowledgeList(@Param(Constants.WRAPPER) IPage<CourseKnowledge> page,
                                                   @Param(Constants.WRAPPER) Wrapper<CourseKnowledge> queryWrapper);
}