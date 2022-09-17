package com.lwq.springboot_mybatis.mapper;


import com.lwq.springboot_mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findByID(Integer id);
}
