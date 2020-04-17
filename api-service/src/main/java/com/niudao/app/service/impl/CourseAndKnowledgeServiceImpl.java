package com.niudao.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niudao.app.dao.CourseAndKnowledgeDao;
import com.niudao.app.entity.CourseAndKnowledge;
import com.niudao.app.service.CourseAndKnowledgeService;
import com.niudao.app.vo.CourseVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (CourseAndKnowledge)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@Service("courseAndKnowledgeService")
public class CourseAndKnowledgeServiceImpl extends ServiceImpl<CourseAndKnowledgeDao, CourseAndKnowledge> implements CourseAndKnowledgeService {


    /**
     * 保存视频地址
     * @param courseVo
     * @param courseId
     * @return
     */
    @Override
    public boolean saveBatchKnowledgeList(CourseVo courseVo, String courseId) {
        //1、先删除子表
        this.deleteCourseAndKnowledges(courseId);

        //2、设置关联关系
        List<CourseAndKnowledge> saveList = new ArrayList<>();
        courseVo.getCourseKnowledgeList().forEach(item->{
            CourseAndKnowledge citem = new CourseAndKnowledge();
            citem.setCourseId(courseId);
            citem.setCourseKnowledgeId(item.getCourseKnowledgeId());
            saveList.add(citem);
        });
        //批量保存
        return   this.saveBatch(saveList);
    }

    /**
     * 根据课程ID删除中间表
     * @param courseIdList
     * @return
     */
    @Override
    public int deleteCourseAndKnowledges(String ...courseIdList) {
        //没有传值千万不要往下执行，否则把整张表数据全部删除。
        if(courseIdList !=null && courseIdList.length>0) {
            return this.baseMapper.delete(this.queryWrapper(courseIdList));
        }
        return -1;
    }


    /**
     * 返回一个QueryWrapper条件构造器
     * @param courseIdList
     * @return
     */
    private QueryWrapper queryWrapper(String ...courseIdList){
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.in(StringUtils.checkValNotNull(courseIdList),"course_id",courseIdList);
        return queryWrapper;
    }
}