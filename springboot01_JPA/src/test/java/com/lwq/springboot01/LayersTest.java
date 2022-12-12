package com.lwq.springboot01;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.Entity.yanTest.A;
import com.lwq.springboot01.Entity.yanTest.ADao;

/**
 * 层次结构测试
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class LayersTest {
    @Autowired
    ADao aDao;

    // @Builder.Default
    // @OneToMany(mappedBy = "parentA")
    // private Set<A> childrenA=new HashSet<>();

    // @ManyToOne(cascade = CascadeType.ALL) //或cascade ={CascadeType.PERSIST,CascadeType.MERGE},只有PERSIST会报错
    // @JoinColumn
    // private A parentA;
    @Test
    @Transactional
    @Commit
    void name1() {
        //测试保存
        A a1 = A.builder().id(1).name("a1").build();
        A a2 = A.builder().id(2).name("a2").parentA(a1).build();
        aDao.save(a2);

        //测试查询
        Optional<A> findById = aDao.findById(1);
        A findA = findById.orElseThrow(()->new RuntimeException("未找到数据"));
        System.out.println(findA.getChildrenA());  //这里直接查的话,只有fetch = FetchType.EAGER且不加@Transactional的时候才可以查到,其他情况都不行


    }

    @Test
    @Transactional
    @Commit
    void name2() {
        //测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        Optional<A> findById2 = aDao.findById(2);
        A find2 = findById2.get();
        System.out.println(find1);
        System.out.println(find1.getChildrenA());   //数据库添加数据后,换另一个方法查懒加载就可以了,记得加@Transactional
        System.out.println(find2);

    }

}
