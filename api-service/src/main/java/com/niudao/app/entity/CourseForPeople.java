package com.niudao.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (CourseForPeople)表实体类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@SuppressWarnings("serial")
public class CourseForPeople extends Model<CourseForPeople> {

    @TableId(type = IdType.UUID)
    private String courseForPeopleId;
    
    private String courseForPeopleName;
    
    private Integer courseForPeopleSort;


    public String getCourseForPeopleId() {
        return courseForPeopleId;
    }

    public void setCourseForPeopleId(String courseForPeopleId) {
        this.courseForPeopleId = courseForPeopleId;
    }

    public String getCourseForPeopleName() {
        return courseForPeopleName;
    }

    public void setCourseForPeopleName(String courseForPeopleName) {
        this.courseForPeopleName = courseForPeopleName;
    }

    public Integer getCourseForPeopleSort() {
        return courseForPeopleSort;
    }

    public void setCourseForPeopleSort(Integer courseForPeopleSort) {
        this.courseForPeopleSort = courseForPeopleSort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.courseForPeopleId;
    }
    }