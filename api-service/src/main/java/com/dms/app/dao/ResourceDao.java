package com.dms.app.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dms.app.entity.Resource;
import com.dms.app.vo.ResourceTypeVo;
import com.dms.app.vo.ResourceVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * (Resource)表数据库访问层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
public interface ResourceDao extends BaseMapper<Resource> {


    /**
     * 查询资料模型，注意不能带有where条件，where条件需要从外部传
     * @param page
     * @param queryWrapper
     * @return
     */
    @Select("select \n"+
            "    a.*,\n"+
            "    b.resource_type_name,\n"+
            "    c.id as  organization_id,\n"+
            "    c.name as  organization_name\n"+
            " from resource  a ,resource_type b , organization c\n"+
            " ${ew.customSqlSegment} ")

    IPage<ResourceVo> getResourceVoList(
            @Param(Constants.WRAPPER) IPage<ResourceVo> page,
            @Param(Constants.WRAPPER) Wrapper<ResourceVo> queryWrapper);


}