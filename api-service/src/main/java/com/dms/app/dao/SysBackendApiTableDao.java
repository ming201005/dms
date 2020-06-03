package com.dms.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dms.app.dao.providers.BackendApiProvider;
import com.dms.app.entity.SysBackendApiTable;
import com.dms.app.vo.SysBackendApiVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * (SysBackendApiTable)表数据库访问层
 * 该类由EasyCode工具生成
 * @author
 * @since 2020-03-07 13:46:34
 */
public interface SysBackendApiTableDao extends BaseMapper<SysBackendApiTable> {

    /**
     * 注意：该方法前端暂时没用到！
     *
     * 通过角色获得后台AIP访问地址
     * 一个账号有多个角色。
     * @param roles
     * @return
     */
    @SelectProvider(type = BackendApiProvider.class, method ="backendApiSelectSQL")
    List<SysBackendApiTable> getApiUrlByRoles(@Param("roles") String... roles);


    /**
     * 根据用户名称获得API URL资源鉴权
     * @param username
     * @return
     */
    @SelectProvider(type = BackendApiProvider.class, method ="backendApiByusername")
    List<SysBackendApiTable> getApiUrlByUserName(@Param("username") String username);

    /**
     * 管理员对API进行管理
     */
    @Select("SELECT \n" +
            "    b.backend_api_id,\n" +
            "    a.backend_api_name parentName,\n" +
            "    b.pid,\n" +
            "    b.backend_api_name,\n" +
            "    b.backend_api_sort,\n" +
            "    b.backend_api_url,\n" +
            "    b.backend_api_method,\n" +
            "    b.description\n" +
            "FROM\n" +
            "    sys_backend_api_table a\n" +
            "        RIGHT JOIN\n" +
            "    sys_backend_api_table b ON b.pid = a.backend_api_id\n" +
            "ORDER BY b.backend_api_sort ASC")

    /**
     * 查所有（编辑使用）
     */
    List<SysBackendApiVo> getAllApiList();


}