package com.niudao.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.CourseKnowledge;
import com.niudao.app.vo.CourseKnowledgeVo;

/**
 * (CourseKnowledge)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
public interface CourseKnowledgeService extends IService<CourseKnowledge> {

    /**
     * 查询列表
     * @param page 分页对象
     * @param courseKnowledge 课程对象
     * @return 返回分页后的对象
     */
    IPage<CourseKnowledgeVo> getCourseKnowledgeList(Page<CourseKnowledge> page, CourseKnowledge courseKnowledge);
}