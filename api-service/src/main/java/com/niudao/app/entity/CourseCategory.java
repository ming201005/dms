package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CourseCategory)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@SuppressWarnings("serial")
public class CourseCategory extends Model<CourseCategory> {

    @TableId(type = IdType.UUID)
    private String courseCategoryId;
    
    private String courseCategoryName;
    
    private Integer courseCategorySort;


    public String getCourseCategoryId() {
        return courseCategoryId;
    }

    public void setCourseCategoryId(String courseCategoryId) {
        this.courseCategoryId = courseCategoryId;
    }

    public String getCourseCategoryName() {
        return courseCategoryName;
    }

    public void setCourseCategoryName(String courseCategoryName) {
        this.courseCategoryName = courseCategoryName;
    }

    public Integer getCourseCategorySort() {
        return courseCategorySort;
    }

    public void setCourseCategorySort(Integer courseCategorySort) {
        this.courseCategorySort = courseCategorySort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.courseCategoryId;
    }

    @Override
    public String toString() {
        return "CourseCategory{" +
                "courseCategoryId='" + courseCategoryId + '\'' +
                ", courseCategoryName='" + courseCategoryName + '\'' +
                ", courseCategorySort=" + courseCategorySort +
                '}';
    }
}