package com.lwq.springboot03_mybatis_plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.lwq.springboot03_mybatis_plus.mapper")//不加这个也会扫描跟springboot要扫描的相同路径里的Mapper,这个可以用于扫描其他路径下的mapper
public class Springboot03MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03MybatisPlusApplication.class, args);
    }

}
