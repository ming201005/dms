package com.niudao.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niudao.app.dao.CourseKnowledgeDao;
import com.niudao.app.entity.CourseKnowledge;
import com.niudao.app.service.CourseKnowledgeService;
import com.niudao.app.vo.CourseKnowledgeVo;
import org.springframework.stereotype.Service;

/**
 * (CourseKnowledge)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@Service("courseKnowledgeService")
public class CourseKnowledgeServiceImpl extends ServiceImpl<CourseKnowledgeDao, CourseKnowledge> implements CourseKnowledgeService {
    /**
     * 查询列表
     * @param page 分页对象
     * @param courseKnowledge 课程对象
     * @return 返回分页后的对象
     */
    @Override
    public IPage<CourseKnowledgeVo> getCourseKnowledgeList(Page<CourseKnowledge> page, CourseKnowledge courseKnowledge) {
        if(page == null) page = new Page<>();
        //创建查询条件对象
        QueryWrapper<CourseKnowledge> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("a.course_knowledge_sort");
        return this.baseMapper.getCourseKnowledgeList(page,queryWrapper);
    }
}