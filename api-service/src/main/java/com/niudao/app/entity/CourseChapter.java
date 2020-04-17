package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CourseChapter)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-04-11 17:32:51
 */
@SuppressWarnings("serial")
public class CourseChapter extends Model<CourseChapter> {

    @TableId(type = IdType.UUID)
    private String courseChapterId;
    
    private String courseId;
    
    private String courseChapterName;
    
    private String courseChapterImg;
    
    private String courseChapterText;
    
    private Integer courseChapterType;
    
    private Integer courseChapterSort;


    public String getCourseChapterId() {
        return courseChapterId;
    }

    public void setCourseChapterId(String courseChapterId) {
        this.courseChapterId = courseChapterId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseChapterName() {
        return courseChapterName;
    }

    public void setCourseChapterName(String courseChapterName) {
        this.courseChapterName = courseChapterName;
    }

    public String getCourseChapterImg() {
        return courseChapterImg;
    }

    public void setCourseChapterImg(String courseChapterImg) {
        this.courseChapterImg = courseChapterImg;
    }

    public String getCourseChapterText() {
        return courseChapterText;
    }

    public void setCourseChapterText(String courseChapterText) {
        this.courseChapterText = courseChapterText;
    }

    public Integer getCourseChapterType() {
        return courseChapterType;
    }

    public void setCourseChapterType(Integer courseChapterType) {
        this.courseChapterType = courseChapterType;
    }

    public Integer getCourseChapterSort() {
        return courseChapterSort;
    }

    public void setCourseChapterSort(Integer courseChapterSort) {
        this.courseChapterSort = courseChapterSort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.courseChapterId;
    }
    }