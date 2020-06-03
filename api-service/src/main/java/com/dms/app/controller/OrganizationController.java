package com.dms.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dms.app.entity.Organization;
import com.dms.app.service.OrganizationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Organization)表控制层
 *
 * @author 
 * @since 2020-04-21 19:30:48
 */
@RestController
@RequestMapping("organization")
public class OrganizationController extends ApiController {

    //URL : http://LOCCCC:8080/organization/XXX
    // {
    // }

    /**
     * 服务对象
     */
    @Resource
    private OrganizationService organizationService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param organization 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Organization> page, Organization organization) {
        return success(this.organizationService.page(page, new QueryWrapper<>(organization)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.organizationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param organization 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Organization organization) {
        return success(this.organizationService.save(organization));
    }

    /**
     * 修改数据
     *
     * @param organization 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Organization organization) {
        return success(this.organizationService.updateById(organization));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.organizationService.removeByIds(idList));
    }
}