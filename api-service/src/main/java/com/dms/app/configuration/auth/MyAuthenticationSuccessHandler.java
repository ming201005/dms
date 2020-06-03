package com.dms.app.configuration.auth;

import com.baomidou.mybatisplus.extension.api.R;
import com.dms.app.components.JwtTokenUtil;
import com.dms.app.components.TokenCache;
import com.dms.app.entity.Organization;
import com.dms.app.entity.SysFrontendMenuTable;
import com.dms.app.service.OrganizationService;
import com.dms.app.service.SysFrontendMenuTableService;
import com.dms.app.service.auth.AuthUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录成功操作
 * 莫小明
 */
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {
    @Autowired
    SysFrontendMenuTableService service;

    @Autowired
    OrganizationService organizationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        //取得账号信息
        AuthUser authUser = (AuthUser) authentication.getPrincipal();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //
        System.out.println("当前用户 authUser = " + authUser);
        //取token
        //好的解决方案，登录成功后token存储到数据库中
        //只要token还在过期内，不需要每次重新生成
        //先去缓存中找

        String token = TokenCache.getTokenFromCache(authUser.getUsername());
        ///--------

        if(token == null) {
            System.out.println("初次登录，token还没有，生成新token。。。。。。");
            //如果token为空，则去创建一个新的token
            //jwtTokenUtil = new JwtTokenUtil();
            token = jwtTokenUtil.generateToken(authUser);
            //把新的token存储到缓存中
            TokenCache.setToken(authUser.getUsername(),token);
        }
        

        //加载前端菜单
        List<SysFrontendMenuTable> menus = service.getMenusByUserName(authUser.getUsername());

        //加载组织（院系）
        Organization organization = organizationService.getById(authUser.getOrganizationId());

        //
        
        //保存到前端
        Map<String,Object> map = new HashMap<>();
        map.put("organizationid",organization.getId());
        map.put("organizationname",organization.getName());
        map.put("username",authUser.getUsername());
        map.put("auth",authUser.getAuthorities());
        map.put("menus",menus);
        map.put("token",token);
        //装入token
        R<Map<String,Object>> data = R.ok(map);

        //输出
        this.WriteJSON(request, response, data);

    }
}
