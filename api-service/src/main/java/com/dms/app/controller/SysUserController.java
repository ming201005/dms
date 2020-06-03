package com.dms.app.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dms.app.entity.SysUserTable;
import com.dms.app.service.SysUserService;
 
import com.dms.app.service.auth.AuthUserDetailsServiceImpl;
import com.dms.app.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 登录接口
 */
@RestController
@RequestMapping("user")
public class SysUserController extends ApiController {

    @Autowired
    SysUserService userService;

   /**
     * 查询所有数据集
     * 返回VO对象
     * @return
     */
    @GetMapping
    public R selectAll(Page<SysUserTable> page, SysUserTable sysUserTable) {
        //System.out.print("sysuser ===>"+sysUserTable.getOrganizationId());
        IPage<SysUserVo> list =  userService.getUserVoList(page, sysUserTable);
        return  success(list);
    }

    /**
     * 查询所有数据集
     * @return
     */
    @GetMapping("search")
    public R getList() {
        List<SysUserTable> list =  userService.list();
        return  success(list);
    }

    /**
     * 根据ID查询用户模型
     * @return
     */
    @GetMapping("{id}")
    public R getUserById(@PathVariable String id) {
 
        return success(userService.getUserById(id));
    }

    /**
     * 添加用户、用户自行注册。
     * @param userVo
     * @return
     */
    @PostMapping("register")
    public R register(@RequestBody(required = false) SysUserVo userVo) {
       try {
           //System.out.println("registerVo = " + userVo);
           return  success(userService.register(userVo));
       }catch (Exception e){
           return failed(e.getMessage());
       }
    }

    /**
     * 修改数据
     *
     * @param sysUserVo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysUserVo sysUserVo) {
        
        return success(this.userService.updateUserById(sysUserVo));
    }

    
    /**
     * 修改当前用户信息、包括修改当前账号信息
     *
     * @param sysUserVo 实体对象
     * @return 修改结果
     */
    @PutMapping("updateCurrentUser")
    public R updateCurrentUser(@RequestBody SysUserVo sysUserVo) {
        try {
            System.out.println("sysUserVo = " + sysUserVo);
            return  success(userService.updateCurrentUser(sysUserVo));
        }catch (Exception e){
            return failed(e.getMessage());
        }
    }


    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<String> idList) {
        return success(this.userService.removeByIds(idList));
    }


}
