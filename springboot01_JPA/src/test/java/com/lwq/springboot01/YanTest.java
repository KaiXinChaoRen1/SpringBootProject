package com.lwq.springboot01;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.Entity.yanTest.A;
import com.lwq.springboot01.Entity.yanTest.ADao;
import com.lwq.springboot01.Entity.yanTest.B;
import com.lwq.springboot01.Entity.yanTest.BDao;

@SpringBootTest
public class YanTest {
    
    @Autowired
    ADao aDao;

    @Autowired
    BDao bDao;


    @Transactional
    @Commit
    @Test
    public void name1() {
        A a=A.builder().id(1).name("aaaaaaaaa").build();
        B b=B.builder().id(2).name("bbbbbbbbb").build();
 
        b.setA(a);
        B saveB = bDao.save(b);

        System.out.println("通过b get a==================="+saveB.getA());

        //此时从数据库中取A
        Optional<A> byId = aDao.findById(1);
        A findA = byId.get();
        System.out.println(a==findA);

        System.out.println("通过a get b===================>"+findA.getBSet());
        
    }

    @Transactional
    @Commit
    @Test
    public void name2() {

        Optional<A> byId = aDao.findById(1);
        A findA = byId.get();
        System.out.println("单独从数据库===================>"+findA.getBSet());
        
    }

}
