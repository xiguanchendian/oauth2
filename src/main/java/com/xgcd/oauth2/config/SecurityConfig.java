package com.xgcd.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)// 由于资源服务器和授权服务器在一起,需要用@Order注解提升Spring Security配置的优先级,
// 如果资源服务器和授权服务器分开,SecurityConfig 和 AuthServerConfig 都是授权服务器需要提供的东西
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 用于密码的加解密
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    // 配置两个用户,提供基于内存的用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root")
                .password("$2a$10$cEytWErb1rIZ16qKZ2zSKuGz4m2pDWUZGfYksMeOEz6vnF3g7aIrm")
                .roles("admin")
                .and()
                .withUser("习惯沉淀")
                .password("$2a$10$cEytWErb1rIZ16qKZ2zSKuGz4m2pDWUZGfYksMeOEz6vnF3g7aIrm")
                // .password(passwordEncoder().encode("123456"))
                .roles("user");
    }

    // 对认证相关的端点放行,同时配置登录页面和登录接口
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth/**")
                .authorizeRequests()
                .antMatchers("/oauth/**", "/static/**", "/static/css/**", "/webjars/**")
                .permitAll()
                .and()
                .csrf().disable();
    }

    // 对静态资源放行
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/**", "/webjars/**");
        super.configure(web);
    }
}
