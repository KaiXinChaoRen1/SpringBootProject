package com.lwq.precious.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 测试threadlocal的用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    Long count;
    LocalDateTime firstTime;
}
