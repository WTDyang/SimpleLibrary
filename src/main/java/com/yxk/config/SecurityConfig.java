package com.yxk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
// 开启基于方法的安全认证机制，web层的controller启用注解机制的安全确认
// prePostEnabled = true :解锁 @PreAuthorize 方法执前验证
// 和 @PostAuthorize  方法执行后验证 两个注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and().authorizeRequests().antMatchers("/user/login","/user/regist").permitAll();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        // 可以直接访问的静态数据
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/404.html")
                .antMatchers("/500.html")
                .antMatchers("/html/**")
                .antMatchers("/js/**");
    }

    //加载BCrypt密码编码器
    @Bean
    public PasswordEncoder pe(){
        return new BCryptPasswordEncoder();
    }


}
