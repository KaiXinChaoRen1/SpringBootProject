package com.lwq.springboot01.controller;

import com.lwq.springboot01.Entity.schoolstory.Person;
import com.lwq.springboot01.Entity.yanTest.A;
import com.lwq.springboot01.Entity.yanTest.ADao;
import com.lwq.springboot01.Entity.yanTest.B;
import com.lwq.springboot01.Entity.yanTest.BDao;
import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
public class HelloController {

    @Autowired
    private PersonRepository pr;

    @Autowired
    ADao aDao;

    @Autowired
    BDao bDao;

//    @GetMapping("/cacheupdate")
//    public String cacheupdate() throws InterruptedException {
//        Person person = pr.findById(1).get();
//        person.setName("lllllllllllll");
//        pr.save(person);
//        return "执行完毕";
//    }
//
//    @GetMapping("/cachefind")
//    public String cache(){
//        System.out.println(pr.findById(1).get());
//        return "执行完毕";
//    }
//
//    @GetMapping("/cacheadd")
//    public String cacheadd(){
//        Person p1 = Person.builder().name("lwq").age(55).build();
//        pr.save(p1);
//        return "执行完毕";
//    }

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
        A a = A.builder().id(1).name("aaaaaaaaa").build();
        B b = B.builder().id(2).name("bbbbbbbbb").build();
        b.setA(a);
        B saveB = bDao.save(b);
        System.out.println("通过b get a===================" + saveB.getA());
        Optional<A> byId = aDao.findById(1);
        A findA = byId.get();
        System.out.println(a == findA);
        System.out.println("通过a get b===================>" + findA.getBSet());
        return "看控制台";
    }

    /**
     * 测试Jpa的多层次结构
     */
    @GetMapping("/hehe5")
    public String hehe5() {
        testMoreLayers();
        return "testMoreLayers看控制台";
    }

    @GetMapping("/hehe6")
    public String hehe6() {
        testMoreLayers2();
        return "testMoreLayers222222222看控制台";
    }


    /**
     * 测试Jpa的多层次结构(一切正常)
     */
    public void testMoreLayers() {
        A aaa = A.builder().id(1).name("aaa").build();
        A bbb = A.builder().id(2).name("bbb").build();
        A ccc = A.builder().id(3).name("ccc").build();
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




    }

    /**
     * 测试builder,(也是正常的)
     */
    public void testMoreLayers2() {
        A aaa = A.builder().id(1).name("aaa").build();
        aDao.save(aaa);
        A bbb = A.builder().id(2).name("bbb").parentA(aaa).build();
        aDao.save(bbb);
        A ccc = A.builder().id(3).name("ccc").parentA(bbb).build();
        aDao.save(ccc);

        //从子往父查看
        Optional<A> byId = aDao.findById(3);
        System.out.println(byId.get());

        //从父往子查看
        Optional<A> byId1 = aDao.findById(1);
        A a1 = byId1.get();

        Set<A> childrenA = a1.getChildrenA();
        System.out.println(childrenA);

        A a2=null;
        for (A a : a1.getChildrenA()) {
            if(a.getName().equals("bbb")){
                a2=a;
            }
        }
        System.out.println(a2);


    }
}
