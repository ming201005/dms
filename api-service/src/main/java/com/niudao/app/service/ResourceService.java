package com.niudao.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.niudao.app.entity.Resource;

import java.util.List;

/**
 * (Resource)表服务接口
 * 该类由EasyCode工具生成
 * @author 小明哥
 * @since 2020-03-15 22:49:39
 */
public interface ResourceService extends IService<Resource> {
    List<Resource> getListByIds(String ids);
}