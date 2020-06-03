package com.dms.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dms.app.dao.ResourceTypeDao;
import com.dms.app.entity.ResourceType;
import com.dms.app.service.ResourceTypeService;
import org.springframework.stereotype.Service;

/**
 * (ResourceType)表服务实现类
 *
 * @author 
 * @since 2020-04-21 19:51:54
 */
@Service("resourceTypeService")
public class ResourceTypeServiceImpl extends ServiceImpl<ResourceTypeDao, ResourceType> implements ResourceTypeService {

}