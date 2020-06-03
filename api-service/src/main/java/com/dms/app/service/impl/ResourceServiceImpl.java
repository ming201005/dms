package com.dms.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dms.app.dao.ResourceDao;
import com.dms.app.entity.Resource;
import com.dms.app.service.ResourceService;
import com.dms.app.service.auth.AuthUser;
import com.dms.app.service.auth.AuthUserDetailsServiceImpl;
import com.dms.app.vo.ResourceVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * (Resource)表服务实现类
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceDao, Resource> implements ResourceService {


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //保持和数据库一致的名字
    private final String viewDocRole[] = {"ROLE_ADMIN","ROLE_院系管理员"};

    @Autowired
    AuthUserDetailsServiceImpl authUserDetailsServiceImpl;
    
    /**
     * 查询资料
     * @param page 分页对象 
     * @param resource  资料对象
     * @param isPublic  是否查询公开资料
     * @return
     */
    @Override
    public IPage<ResourceVo> getResourceVoList(final IPage<ResourceVo> page,final ResourceVo resourceVo,boolean isPublic) {

       log.info("resourceVo====="+resourceVo); 
    
        //处理搜索相关
        QueryWrapper<ResourceVo>  queryWrapper = new QueryWrapper<>();
            
        //基础的关联查询
        queryWrapper.apply("a.type_id=b.id","").apply("b.organization_id=c.id","");

        //如果是查询公开资料
        if(isPublic){
            queryWrapper.eq("a.resource_state",1);
        }else{
            //控制管理员和个人查看资料范围权限 start
            //得到当前登录人
            AuthUser user = authUserDetailsServiceImpl.getCurrentUser();
            List<GrantedAuthority> roles = (List<GrantedAuthority>) user.getAuthorities();
            // 如果不是高级管理员和院系管理员，只能查看个人上传的资料
            if(!hashView(roles) && !isPublic){
                queryWrapper.eq(StringUtils.checkValNotNull(user.getUsername()), "a.up_user",user.getUsername());
            }
        }

        //组织ID
        queryWrapper.eq(StringUtils.checkValNotNull(resourceVo.getOrganizationId()), "c.id",resourceVo.getOrganizationId());
        
        //分类ID
        queryWrapper.eq(StringUtils.checkValNotNull(resourceVo.getTypeId()), "a.type_id",resourceVo.getTypeId());

        //如果ID有值，查询ID
        queryWrapper.eq(StringUtils.checkValNotNull(resourceVo.getId()), "a.id",resourceVo.getId());

        //搜搜关键字，匹配文件名称
        queryWrapper.like(StringUtils.checkValNotNull(resourceVo.getResourceName()), "a.resource_name",resourceVo.getResourceName());

        //上传时间,时间格式化
        if(StringUtils.checkValNotNull(resourceVo.getDatetime1()) && StringUtils.checkValNotNull(resourceVo.getDatetime2()) ) {
            queryWrapper.apply("a.create_time between {0} and {1}", resourceVo.getDatetime1(),resourceVo.getDatetime2());
        }
        return this.baseMapper.getResourceVoList(page, queryWrapper);
    }
    

    /**
     * 查询某个资料
     * @param id id 
     * @return
     */
    @Override
    public  ResourceVo getResourceVoById(Integer id){
        ResourceVo resourceVo = null;
        if(id != null && id> 0){
            ResourceVo resource = new ResourceVo();
            resource.setId(id);
            IPage<ResourceVo> page  =  this.getResourceVoList(new Page<>(),resource,false);
            resourceVo = page.getRecords().get(0);
       }
       return resourceVo;
    }

    /**
     * 保存资料
     */
    @Override
    public Resource saveResource(final ResourceVo resourceVo) {
        // 文件后缀
        // 文件状态，0：私有；1：公共
        final Resource resource = new Resource();
        // ID
        resource.setId(resourceVo.getId() == -1 ? null : resourceVo.getId());
        // 文件保存名称
        resource.setResourceName(resourceVo.getResourceName());
        // 文件类型ID-外键
        resource.setTypeId(resourceVo.getTypeId());
        // 物理视频上存储的文件名称
        resource.setPathResourceName(resourceVo.getPathResourceName());
        // 上传时间
        resource.setCreateTime(new Date());
        // 文件大小（单位MB)
        resource.setResourceSize(resourceVo.getResourceSize());
        // 文件后缀：doc、pdf、等
        resource.setFileSuffix(resourceVo.getFileSuffix());
        // 文件状态，0：私有；1：公共
        resource.setResourceState(resourceVo.getResourceState());
        // 文件上传人
        resource.setUpUser(resourceVo.getUpUser());
        // 文件描述
        resource.setDes(resourceVo.getDes());

        if (resource.getId() == null) {
            this.save(resource);
        } else {
            this.saveOrUpdate(resource);
        }

        return resource;
    }

    /**
     * 根据ID查询附件
     * 
     * @param ids
     * @return
     */
    @Override
    public List<Resource> getListByIds(final String ids) {

        List<Resource> list = new ArrayList<>();

        if (StringUtils.isNotEmpty(ids)) {

            final String[] idList = ids.split(",");

            final LambdaQueryWrapper<Resource> queryWrapper = new QueryWrapper().lambda();

            queryWrapper.in (StringUtils.isNotEmpty (ids), Resource::getId, Arrays.asList(idList));

            list = this.list (queryWrapper);

        }

        //log.info ("service list==>" + list.toString ());

        return list;

    }



    /**
     * 当前用户的所有角色
     * @param roles
     * @return
     */
    private boolean hashView(List<GrantedAuthority> roles){
        for (GrantedAuthority role : roles) {
           return Arrays.stream(viewDocRole).anyMatch(item->item.equals(role.getAuthority()));
        }
        return false;
    }
}