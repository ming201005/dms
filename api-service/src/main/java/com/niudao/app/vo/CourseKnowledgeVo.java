package com.niudao.app.vo;

import com.niudao.app.entity.CourseKnowledge;

public class CourseKnowledgeVo extends CourseKnowledge {

    private  String courseCategoryName;

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }
}
