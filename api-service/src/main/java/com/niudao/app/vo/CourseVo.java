package com.niudao.app.vo;

import com.niudao.app.entity.*;

import java.util.List;

/**
 * 课程信息展现模型
 */
public class CourseVo extends Course {

    //课程分类
    private CourseCategory courseCategory;

    //课程类型
    private CourseType courseType;

    //课程章节（视频-多份）
    private List<CourseChapter> courseChapterList;

    //课程知识点-一个课程涉及多个知识点
    private List<CourseKnowledge> courseKnowledgeList;

    //适用人群(一套课程可以使用多人群)
    private List<CourseForPeople> courseForPeopleList;


    public CourseCategory getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategory courseCategory) {
        this.courseCategory = courseCategory;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public List<CourseForPeople> getCourseForPeopleList() {
        return courseForPeopleList;
    }

    public void setCourseForPeopleList(List<CourseForPeople> courseForPeopleList) {
        this.courseForPeopleList = courseForPeopleList;
    }

    public List<CourseKnowledge> getCourseKnowledgeList() {
        return courseKnowledgeList;
    }

    public void setCourseKnowledgeList(List<CourseKnowledge> courseKnowledgeList) {
        this.courseKnowledgeList = courseKnowledgeList;
    }

    public List<CourseChapter> getCourseChapterList() {
        return courseChapterList;
    }

    public void setCourseChapterList(List<CourseChapter> courseChapterList) {
        this.courseChapterList = courseChapterList;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                super.toString()+
                "，courseCategory=" + courseCategory +
                ", courseType=" + courseType +
                ", courseForPeopleList=" + courseForPeopleList +
                ", courseKnowledgeList=" + courseKnowledgeList +
                ", courseChapterList=" + courseChapterList +
                '}';
    }
}
