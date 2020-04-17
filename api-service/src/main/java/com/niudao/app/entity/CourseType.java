package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CourseType)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@SuppressWarnings("serial")
public class CourseType extends Model<CourseType> {

    @TableId(type = IdType.UUID)
    private String courseTypeId;
    
    private String courseTypeName;
    
    private Integer courseTypeSort;


    public String getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(String courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    public Integer getCourseTypeSort() {
        return courseTypeSort;
    }

    public void setCourseTypeSort(Integer courseTypeSort) {
        this.courseTypeSort = courseTypeSort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.courseTypeId;
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "courseTypeId='" + courseTypeId + '\'' +
                ", courseTypeName='" + courseTypeName + '\'' +
                ", courseTypeSort=" + courseTypeSort +
                '}';
    }
}