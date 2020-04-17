package com.niudao.app.vo;

import com.niudao.app.entity.Course;

/**
 * web端需要的模型
 */
public class WebCourseVo extends Course  {

    private String courseTypeName;

    private String courseCategoryName;

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }
}
