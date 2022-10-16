package com.lwq.springboot01.controller;

import com.lwq.springboot01.Entity.Test.A;
import com.lwq.springboot01.Entity.Test.ADao;
import com.lwq.springboot01.Entity.Test.B;
import com.lwq.springboot01.Entity.Test.BDao;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.Entity.Person;
import com.lwq.springboot01.dao.PersonRepository;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private PersonRepository pr;

    @Autowired
    ADao aDao;

    @Autowired
    BDao bDao;

    @GetMapping("/")
    public String hehe() {
        return "我家大门常打开,开放怀抱等你";
    }

    @GetMapping("/hehe1")
    public String hehe1() {
        return "Spring Boot1111111111111111111111";
    }

    @GetMapping("/hehe2")
    public String hehe2() {
        return "Spring Boot22222222222222222222222";
    }

    @GetMapping("/hehe3")
    public List<Person> hehe3() {
        List<Person> findAll = pr.findAll();
        return findAll;
    }

    @GetMapping("/hehe4")
    public String hehe4() {
        //内容同YanTest
        A a=A.builder().id(1).name("aaaaaaaaa").build();
        B b=B.builder().id(2).name("bbbbbbbbb").build();
        b.setA(a);
        B saveB = bDao.save(b);
        System.out.println("通过b get a==================="+saveB.getA());
        Optional<A> byId = aDao.findById(1);
        A findA = byId.get();
        System.out.println(a==findA);
        System.out.println("通过a get b===================>"+findA.getBSet());
        return "看控制台";
    }

    /**
     * 测试Jpa的多层次结构
     */
    @GetMapping("/hehe5")
    public String  hehe5() {
        testMoreLayers();
        return "看控制台..lll";
    }


    /**
     * 测试Jpa的多层次结构
     */
    public void testMoreLayers(){
        A aaa=A.builder().id(1).name("aaa").build();
        A bbb=A.builder().id(2).name("bbb").build();
        A ccc=A.builder().id(3).name("ccc").build();
        aDao.save(aaa);
        bbb.setParentA(aaa);
        aDao.save(bbb);
        ccc.setParentA(bbb);
        aDao.save(ccc);

        Optional<A> byId = aDao.findById(3);
        System.out.println(byId.get());

        Optional<A> byId1 = aDao.findById(1);
        Set<A> childrenA = byId1.get().getChildrenA();
        System.out.println(childrenA);

        Optional<A> byId2 = aDao.findById(2);
        Set<A> childrenAA = byId2.get().getChildrenA();
        System.out.println(childrenAA);



    }
}
