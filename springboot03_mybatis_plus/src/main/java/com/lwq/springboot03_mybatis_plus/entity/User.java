package com.lwq.springboot03_mybatis_plus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lwq_user")
public class User {
    private Integer id;
    @TableField("username")
    private String userName;
    private String password;
}
