package com.lwq.springboot03_mybatis_plus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwq.springboot03_mybatis_plus.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
