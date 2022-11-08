package com.lwq.springboot01;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.springboot01.Entity.inherit.Color;
import com.lwq.springboot01.Entity.inherit.Dijia;
import com.lwq.springboot01.Entity.inherit.FastDijia;
import com.lwq.springboot01.Entity.inherit.StrongDijia;
import com.lwq.springboot01.dao.inheritRepository.ColorRepository;
import com.lwq.springboot01.dao.inheritRepository.DijiaRepository;
import com.lwq.springboot01.dao.inheritRepository.FastDijiaRepository;
import com.lwq.springboot01.dao.inheritRepository.StrongDijiaRepository;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * JPA中表之间有继承的学习
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class inheritTest {
    @Autowired
    DijiaRepository dr;
    @Autowired
    StrongDijiaRepository sr;
    @Autowired
    FastDijiaRepository fr;
    @Autowired
    ColorRepository cr;

    //雪花算法生成uuid的Hutool工具类
    private static Snowflake snowflake = IdUtil.getSnowflake(1, 1);


    
    @Test
    public void name1() {
        
        Dijia d = Dijia.builder().uuid(snowflake.nextIdStr()).power(90).speed(90).build();

        StrongDijia sd = StrongDijia.builder().uuid(snowflake.nextIdStr()).power(100).speed(80).skill("迪拉修姆光流").build();
        FastDijia fd = FastDijia.builder().uuid(snowflake.nextIdStr()).power(80).speed(100).skill("兰帕尔特光弹").build();

        Color blue = Color.builder().uuid(snowflake.nextIdStr()).name("蓝色").dijia(fd).build();
        Color red = Color.builder().uuid(snowflake.nextIdStr()).name("红色").dijia(sd).build();

        cr.save(blue);
        cr.save(red);

    }

    @Test
    public void name2() {
        
        Color blue = Color.builder().uuid(snowflake.nextIdStr()).name("蓝色").build();
        Color red = Color.builder().uuid(snowflake.nextIdStr()).name("红色").build();

        StrongDijia sd = StrongDijia.builder().uuid(snowflake.nextIdStr()).power(100).speed(80).skill("迪拉修姆光流").color(red).build();
        FastDijia fd = FastDijia.builder().uuid(snowflake.nextIdStr()).power(80).speed(100).skill("兰帕尔特光弹").color(blue).build();

        sr.save(sd);
        fr.save(fd);

    }

    @Test
    public void name3() {
        Optional<Color> colorOptional = cr.findById("1589923982461767681");
        Color color = colorOptional.get();
        StrongDijia dijia = (StrongDijia) color.getDijia();
        System.out.println(dijia);
    }


    @Test
    public void name4() {
        String id="1589923982465961984";

        //通过自己的Repository查询
        Optional<FastDijia> findById = fr.findById(id);
        FastDijia fastDijia = findById.get();
        System.out.println(fastDijia);


        //通过父类的Repository查询
        Optional<Dijia> findById2 = dr.findById(id);
        Dijia dijia = findById2.get();
        System.out.println(dijia);

        //通过父类的Repository查询并强转
        Optional<Dijia> findById3 = dr.findById(id);
        FastDijia fastDijia2 = (FastDijia) findById3.get();
        System.out.println(fastDijia2);
    }

    /**
     * 测试子类的toString
     */
    @Test
    public void name5() {
        //父类的toString
        Dijia build2 = Dijia.builder().uuid("1").power(111).speed(111).build();
        System.out.println(build2);


        //子类的toString(子类需要加上@ToString(callSuper = true))
        FastDijia build = FastDijia.builder().uuid("1").power(111).speed(111).skill("飞踢").build();
        System.out.println(build);
    }
    
}
