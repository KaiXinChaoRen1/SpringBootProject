package com.lwq.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//数据库查询
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置各种功能
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //没有权限跳转的路径（不设置就是403）
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        //登陆页面的设置
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/user/login")//表单提交的action
                .defaultSuccessUrl("/test/index").permitAll()
                .and().authorizeRequests()
                    .antMatchers("/","/user/login","/test/hello").permitAll()//那些路径不需要认证就可以直接访问
                                                                               //基于权限或角色进行访问控制的四种方法
                    //.antMatchers("/test/index").hasAuthority("admins")                     //1.具有某权限才能访问，否则403
                    //.antMatchers("/test/index").hasAnyAuthority("admins,manager")          //2.多个权限的任意一种的情况
                    //.antMatchers("/test/index").hasRole("sale")                            //3.是某个角色
                    .antMatchers("/test/index").hasAnyRole("sale,role")  //4.多个角色中的一个
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}


/*
//直接在配置类设置用户名和密码(不实用)，查数据库那种才实用
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("666");
        auth.inMemoryAuthentication().withUser("lwq").password(password).roles("admin");

    }
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }
}
*/
