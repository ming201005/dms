package com.niudao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.CourseAndKnowledge;
import com.niudao.app.vo.CourseVo;

/**
 * (CourseAndKnowledge)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseAndKnowledgeService extends IService<CourseAndKnowledge> {

    /**
     * 保存视频地址
     * @param courseVo
     * @param courseId
     * @return
     */
     boolean saveBatchKnowledgeList(CourseVo courseVo, String courseId);

    /**
     * 根据课程ID删除中间表
     * @param courseIdList
     * @return
     */
    int deleteCourseAndKnowledges(String ...courseIdList);
}