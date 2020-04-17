package com.niudao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.CourseAndPeople;
import com.niudao.app.vo.CourseVo;

/**
 * (CourseAndPeople)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseAndPeopleService extends IService<CourseAndPeople> {

    /**
     * 保存课程和适用人群中间表
     * @param courseVo
     * @param courseId
     * @return
     */
    boolean saveBatchCourseAndPeopleList(CourseVo courseVo, String courseId);

    /**
     * 根据课程ID删除中间表
     * @param courseIdList
     * @return
     */
    int deleteCourseAndPeoplees(String ...courseIdList);
}