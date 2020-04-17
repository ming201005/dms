package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CourseAndKnowledge)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@SuppressWarnings("serial")
public class CourseAndKnowledge extends Model<CourseAndKnowledge> {

    @TableId(type = IdType.UUID)
    private String id;
    
    private String courseId;
    
    private String courseKnowledgeId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseKnowledgeId() {
        return courseKnowledgeId;
    }

    public void setCourseKnowledgeId(String courseKnowledgeId) {
        this.courseKnowledgeId = courseKnowledgeId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }