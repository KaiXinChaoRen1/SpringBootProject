package com.lwq.springboot01;

import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.lwq.springboot01.Entity.Test.A;
import com.lwq.springboot01.Entity.Test.ADao;
import com.lwq.springboot01.Entity.Test.B;
import com.lwq.springboot01.Entity.Test.BDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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
