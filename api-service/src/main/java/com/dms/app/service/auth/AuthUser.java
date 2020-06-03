package com.dms.app.service.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 要实现UserDetails接口，这个接口是security提供的
 */
@Component
public class AuthUser implements UserDetails {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // 登录账号
    private String username;

    //登录密码
    private String password;

    //账户状态
    private Integer state;

    //组织，对应院系主键
    private Integer organizationId;

    private Collection<? extends GrantedAuthority> authorities;

    //无参数构造方法
    public AuthUser() {
    }

    //多参数构造方法
    public AuthUser(String username, 
                    String password, 
                    Integer state,
                    Integer organizationId, 
                    Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.state = state;
        this.organizationId = organizationId;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未被锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }



    @Override
    public String toString() {
        return "AuthUser:{" +
                "  username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state + '\'' +
                ", organizationId="+organizationId+ '\'' +
                ", authorities=" + authorities + '\'' +
                '}';
    }
}
