package com.lwq.springboot01;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.lwq.springboot01.Entity.Test.A;
import com.lwq.springboot01.Entity.Test.ADao;
import com.lwq.springboot01.Entity.Test.B;
import com.lwq.springboot01.Entity.Test.BDao;

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
        A a=A.builder().name("aaaaaaaaa").build();
        B b=B.builder().name("bbbbbbbbb").build();
 
        b.setA(a);
        b= bDao.save(b);

        System.out.println("==================="+b.getA());

        Optional<A> findById = aDao.findById(1);
        A a2 = findById.get();
        System.out.println(a==a2);
        System.out.println("==================="+a2.getName());
        
        System.out.println("==================="+a2.getBSet());
        
    }

    @Transactional
    @Commit
    @Test
    public void name2() {
       
        Optional<A> findById = aDao.findById(1);
        
        System.out.println("==================="+findById.get().getBSet());
        
    }

}
