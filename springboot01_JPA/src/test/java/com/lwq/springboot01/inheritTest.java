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
 * 当JPA遇到继承
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

    // 雪花算法生成uuid的Hutool工具类
    private static Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    @Test
    public void value1() {

        StrongDijia sd = StrongDijia.builder().uuid(snowflake.nextIdStr()).power(100).speed(80).skill("迪拉修姆光流")
                .favorite(true).build();
        FastDijia fd = FastDijia.builder().uuid(snowflake.nextIdStr()).power(80).speed(100).skill("兰帕尔特光弹").build();

        Color blue = Color.builder().uuid(snowflake.nextIdStr()).value("蓝色").dijia(fd).build();
        Color red = Color.builder().uuid(snowflake.nextIdStr()).value("红色").dijia(sd).build();

        // color和dijia的数据都会添加,但不会添加外键
        cr.save(blue);
        cr.save(red);

    }

    @Test
    public void value2() {

        Dijia d = Dijia.builder().uuid(snowflake.nextIdStr()).power(90).speed(90).build();
        dr.save(d);

        Color blue = Color.builder().uuid(snowflake.nextIdStr()).value("蓝色").build();
        Color red = Color.builder().uuid(snowflake.nextIdStr()).value("红色").build();

        StrongDijia sd = StrongDijia.builder().uuid(snowflake.nextIdStr()).power(100).speed(80).skill("迪拉修姆光流")
                .favorite(true).color(red).build();
        FastDijia fd = FastDijia.builder().uuid(snowflake.nextIdStr()).power(80).speed(100).skill("兰帕尔特光弹").color(blue)
                .build();

        sr.save(sd);
        fr.save(fd);

    }

    @Test
    public void value3() {
        Optional<Color> colorOptional = cr.findById("1589945531516456961");
        Color color = colorOptional.get();
        Dijia dijia = color.getDijia();
        System.out.println(dijia);
        // System.out.println(dijia.getskill());
        System.out.println(dijia.getClass());

        StrongDijia strongDijia = (StrongDijia) dijia;
        System.out.println(strongDijia);
        System.out.println(strongDijia.getSkill());

    }

    @Test
    public void value4() {
        String id = "1589945531520651264";

        // 1.通过自己的Repository查询
        Optional<FastDijia> findById = fr.findById(id);
        FastDijia fastDijia = findById.get();
        System.out.println(fastDijia);

        // 2.通过父类的Repository查询子类的id
        Optional<Dijia> findById2 = dr.findById(id);
        Dijia dijia = findById2.get();
        System.out.println(dijia);
        System.out.println(dijia.getClass());

        // 2.1.通过父类的Repository查询父类的id
        Optional<Dijia> findById4 = dr.findById("1589945531034112000");
        Dijia dijia2 = findById4.get();
        System.out.println(dijia2);
        System.out.println(dijia2.getClass());

        // 3.通过父类的Repository查询并强转
        Optional<Dijia> findById3 = dr.findById(id);
        FastDijia fastDijia2 = (FastDijia) findById3.get();
        System.out.println(fastDijia2);
    }

    /**
     * 测试子类的toString
     */
    @Test
    public void value5() {
        // 父类的toString
        Dijia build2 = Dijia.builder().uuid("1").power(111).speed(111).build();
        System.out.println(build2);

        // 子类的toString(子类需要加上@ToString(callSuper = true))
        FastDijia build = FastDijia.builder().uuid("1").power(111).speed(111).skill("飞踢").build();
        System.out.println(build);
    }

}
