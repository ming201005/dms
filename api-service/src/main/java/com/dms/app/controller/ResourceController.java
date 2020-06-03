package com.dms.app.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dms.app.components.FileUtil;
import com.dms.app.entity.Resource;
import com.dms.app.service.ResourceService;
import com.dms.app.service.auth.AuthUser;
import com.dms.app.vo.ResourceVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

 
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (Resource)表控制层
 * 该类由EasyCode工具生成
 * @author
 * @since 2020-03-15 22:49:39
 */
@RestController
@RequestMapping("resource")
public class ResourceController extends ApiController {

    @Autowired
    FileUtil fileUtil;
    /**
     * 服务对象
     */
    @Autowired
    private ResourceService resourceService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param resourceVo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(final Page<ResourceVo> page, final ResourceVo resourceVo) {

        return success(this.resourceService.getResourceVoList(page, resourceVo,false));
    }

    /**
     * 分页查询所有公开的数据
     *
     * @param page 分页对象
     * @param resourceVo 查询实体
     * @return 所有数据
     */
    @GetMapping("public")
    public R selectPublicData(final Page<ResourceVo> page, final ResourceVo resourceVo) {

        return success(this.resourceService.getResourceVoList(page, resourceVo,true));
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable final Integer id) {
        return success(this.resourceService.getResourceVoById(id));
    }

    /**
     * 上传资料和保存数据
     * 
     * @param file
     * @param response
     * @return
     * @throws IOException
     */
    @PostMapping("uploadFile")
    public R uploadFile(final HttpServletResponse response,
            @RequestParam(value = "file", required = false) final MultipartFile file, final ResourceVo vo)
            throws IOException {

        return this.fileUtil.upFileDoc(response, file, vo);
    }

    /**
     * 资料下载
     * 
     * @param response
     * @param filename
     * @return
     */
    @GetMapping("downLoad")
    public R downLoad(final HttpServletResponse response, @RequestParam("filename") final String filename) {
        try {
            return success(this.fileUtil.downLoad(response, filename));
        } catch (final Exception e) {
            return failed("下载失败");
        }
    }

    /**
     * 在线预览资料
     * 
     * @param response
     * @param filename
     * @return
     */
    // 后续可以研究开源的。
    // @GetMapping("conversionFile")
    // public R conversionFile(HttpServletResponse response,
    // @RequestParam("filename") String filename){
    // try {
    // this.fileUtil.conversionFile(response, filename);
    // return success("预览成功");
    // } catch (Exception e) {
    // return failed("预览失败");
    // }
    // }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") final List<String> idList) {
        return success(this.resourceService.removeByIds(idList));
    }

    /**
     * 删除图片和数据库的数据
     *
     * @param idList
     * @return 单条数据
     */
    @DeleteMapping("deleteFile")
    public R<Boolean> deleteFile(@RequestParam("idList") final List<Long> idList,
            @RequestParam("fileName") final String fileName) {

        // 调用删除文件和数据库的方法
        return R.ok(this.fileUtil.deleteFileAndData(idList, fileName));

    }

    /**
     * 设置公开
     *
     * @param id    主键
     * @param state 状态
     * @return 单条数据
     */
    @GetMapping("/setpublic/{id}/{state}")
    public R setPublic(@PathVariable final Integer id, @PathVariable final Integer state) {
        final Resource resource = new Resource();
        //设置状态
        resource.setResourceState(state);
        resource.setId(id);
        return success(this.resourceService.updateById(resource));
    }

}