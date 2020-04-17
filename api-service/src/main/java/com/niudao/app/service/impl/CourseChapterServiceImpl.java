package com.niudao.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niudao.app.dao.CourseChapterDao;
import com.niudao.app.entity.CourseChapter;
import com.niudao.app.service.CourseChapterService;
import com.niudao.app.vo.CourseVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (CourseChapter)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@Service("courseChapterService")
public class CourseChapterServiceImpl extends ServiceImpl<CourseChapterDao, CourseChapter> implements CourseChapterService {


    /**
     * 保存视频地址
     * @param courseVo
     * @param courseId
     * @return
     */
    @Override
    public boolean saveBatchChapterList(CourseVo courseVo, String courseId) {
        //1、先删除子表,即视频表
        this.deleteCourseChapters(courseId);

        //2、设置关联关系
        List<CourseChapter> courseChapterList = courseVo.getCourseChapterList();
        //设置主表ID，让两个表形成关联
        courseChapterList.forEach(item->item.setCourseId(courseId));
        //批量保存
        return   this.saveBatch(courseChapterList);
    }

    /**
     * 通过课程ID查章节
     * @param courseId
     * @return
     */
    @Override
    public List<CourseChapter> getCourseChapterList(String courseId) {
        return this.baseMapper.selectList(this.queryWrapper(courseId));
    }


    /**
     * 根据课程ID删除课程章节
     * @param courseIdList
     * @return
     */
    @Override
    public int deleteCourseChapters(String ...courseIdList) {
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