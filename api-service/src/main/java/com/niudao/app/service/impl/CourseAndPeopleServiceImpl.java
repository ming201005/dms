package com.niudao.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.niudao.app.dao.CourseAndPeopleDao;
import com.niudao.app.entity.CourseAndPeople;
import com.niudao.app.service.CourseAndPeopleService;
import com.niudao.app.vo.CourseVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (CourseAndPeople)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-28 18:43:04
 */
@Service("courseAndPeopleService")
public class CourseAndPeopleServiceImpl extends ServiceImpl<CourseAndPeopleDao, CourseAndPeople> implements CourseAndPeopleService {

    /**
     * 保存课程和适用人群中间表
     * @param courseVo
     * @param courseId
     * @return
     */
    @Override
    public boolean saveBatchCourseAndPeopleList(CourseVo courseVo, String courseId) {
        //1、先删除子表
        this.deleteCourseAndPeoplees(courseId);

        //2、设置关联关系
        List<CourseAndPeople> saveList = new ArrayList<>();
        courseVo.getCourseForPeopleList().forEach(item->{
            CourseAndPeople citem = new CourseAndPeople();
            citem.setCourseId(courseId);
            citem.setCourseForPeopleId(item.getCourseForPeopleId());
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
    public int deleteCourseAndPeoplees(String ...courseIdList) {
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