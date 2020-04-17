package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.entity.ResourceType;
import com.niudao.app.service.ResourceTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (ResourceType)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@RestController
@RequestMapping("resourceType")
public class ResourceTypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ResourceTypeService resourceTypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param resourceType 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ResourceType> page, ResourceType resourceType) {
        return success(this.resourceTypeService.page(page, new QueryWrapper<>(resourceType)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.resourceTypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param resourceType 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ResourceType resourceType) {
        return success(this.resourceTypeService.save(resourceType));
    }

    /**
     * 修改数据
     *
     * @param resourceType 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ResourceType resourceType) {
        return success(this.resourceTypeService.updateById(resourceType));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.resourceTypeService.removeByIds(idList));
    }
}