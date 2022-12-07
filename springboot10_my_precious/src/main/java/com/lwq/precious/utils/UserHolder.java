package com.lwq.precious.utils;

import com.lwq.precious.model.SysUser;

/**
 * 每一个进入tomcat的请求都是一个独立的线程?
 * 使用ThreadLocal为每一个用户线程保存用户信息
 *
 * 全是静态方法,不用创建对象
 */
public class UserHolder {
    //ThreadLocal
    private static final ThreadLocal<SysUser> tl = new ThreadLocal<>();


    //存
    public static void saveUser(SysUser user){
        tl.set(user);
    }
    //取
    public static SysUser getUser(){
        return tl.get();
    }
    //删
    public static void removeUser(){
        tl.remove();
    }
}
