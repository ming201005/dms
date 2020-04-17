package com.niudao.app.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niudao.app.components.FileUtil;
import com.niudao.app.entity.Resource;
import com.niudao.app.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * (Resource)表控制层
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
@RestController
@RequestMapping("resource")
public class ResourceController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private ResourceService resourceService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param resource 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Resource> page, Resource resource) {
        return success(this.resourceService.page(page, new QueryWrapper<>(resource)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.resourceService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param resource 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Resource resource) {
        return success(this.resourceService.save(resource));
    }

    /**
     * 修改数据
     *
     * @param resource 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Resource resource) {
        return success(this.resourceService.updateById(resource));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.resourceService.removeByIds(idList));
    }



    /**
     *
     * @param ids id(逗号分开的多条信息）
     * @return 所有数据
     */
    @GetMapping("isCheck")
    @CrossOrigin
    public R<List<Resource>> selectAll(@RequestParam("ids") String ids) {

        return R.ok (this.resourceService.getListByIds (ids));
    }

    /**
     * 上传文件 (前端传递多个文件时，自动执行多次)
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("upload")
    public Resource uploadWork(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        return  FileUtil.upFile (file, this.resourceService);

    }

    /**
     * 删除图片和数据库的数据
     *
     * @param idList
     * @return 单条数据
     */
    @DeleteMapping("deleteFile")
    public R<Boolean> deleteFile(@RequestParam("idList") List<Long> idList, @RequestParam("fileName") String fileName) {

        return R.ok (FileUtil.deleteFile (idList,fileName,resourceService));

    }


}