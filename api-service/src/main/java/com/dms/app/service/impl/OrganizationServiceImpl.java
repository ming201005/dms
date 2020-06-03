package com.dms.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dms.app.dao.OrganizationDao;
import com.dms.app.entity.Organization;
import com.dms.app.service.OrganizationService;
import org.springframework.stereotype.Service;

/**
 * (Organization)表服务实现类
 *
 * @author 
 * @since 2020-04-21 19:30:48
 */
@Service("organizationService")
public class OrganizationServiceImpl extends ServiceImpl<OrganizationDao, Organization> implements OrganizationService {

}