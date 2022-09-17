package com.lwq.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lwq.security.entity.Users;
import org.springframework.stereotype.Repository;

@Repository//不加也能运行，不过有个报错的下划线
public interface UserMapper extends BaseMapper<Users> {
}
