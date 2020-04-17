package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CourseKnowledge)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-04-07 14:06:06
 */
@SuppressWarnings("serial")
public class CourseKnowledge extends Model<CourseKnowledge> {

    @TableId(type = IdType.UUID)
    private String courseKnowledgeId;
    //分类
    private String courseCategoryId;
    
    private String courseKnowledgeName;
    
    private Integer courseKnowledgeSort;


    public String getCourseKnowledgeId() {
        return courseKnowledgeId;
    }

    public void setCourseKnowledgeId(String courseKnowledgeId) {
        this.courseKnowledgeId = courseKnowledgeId;
    }

    public String getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(String courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseKnowledgeName() {
        return courseKnowledgeName;
    }

    public void setCourseKnowledgeName(String courseKnowledgeName) {
        this.courseKnowledgeName = courseKnowledgeName;
    }

    public Integer getCourseKnowledgeSort() {
        return courseKnowledgeSort;
    }

    public void setCourseKnowledgeSort(Integer courseKnowledgeSort) {
        this.courseKnowledgeSort = courseKnowledgeSort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.courseKnowledgeId;
    }
    }