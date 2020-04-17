package com.niudao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.CourseChapter;
import com.niudao.app.vo.CourseVo;

import java.util.List;

/**
 * (CourseChapter)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseChapterService extends IService<CourseChapter> {

    /**
     * 保存视频地址
     * @param courseVo
     * @param courseId
     * @return
     */
    boolean saveBatchChapterList(CourseVo courseVo, String courseId);

    /**
     * 根据课程ID查询章节
     * @param courseId
     * @return
     */
    List<CourseChapter> getCourseChapterList(String courseId);

    /**
     * 根据课程ID删除课程章节
     * @param courseIdList
     * @return
     */
    int deleteCourseChapters(String ...courseIdList);
}