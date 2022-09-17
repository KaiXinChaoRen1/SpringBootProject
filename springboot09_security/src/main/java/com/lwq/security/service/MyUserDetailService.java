package com.lwq.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lwq.security.entity.Users;
import com.lwq.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据输入的用户名，查询数据库获得User对象，得知数据库中的用户名和密码
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);
        if(users==null){
            throw new UsernameNotFoundException("用户不存在");
        }

        //权限集合
        List<GrantedAuthority> auths= AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale1");//用户的权限,角色
        //用户名和密码给到SpringSecurity ，会自动比对用户输入的进行认证
        return new User(users.getUsername(),
                        new BCryptPasswordEncoder().encode(users.getPassword()),
                        auths);
    }
}
