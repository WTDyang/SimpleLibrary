package com.yxk.simpleLibrary.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * user
 * @author 
 */
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User implements Serializable, UserDetails {

    public User(){}

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    @Size(min = 2, max = 20)
    private String username;

    /**
     * 密码
     */
    @Size(min = 6, max = 30)
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     *  账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /** 账户是否激活
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}