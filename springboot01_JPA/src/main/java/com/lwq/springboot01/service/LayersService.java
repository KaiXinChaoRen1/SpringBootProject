package com.lwq.springboot01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lwq.springboot01.entity.yanTest.A;
import com.lwq.springboot01.entity.yanTest.ADao;

@Service
public class LayersService {

    @Autowired
    private ADao aDao;

    // @Builder.Default
    // @OneToMany(mappedBy = "parentA")
    // private Set<A> childrenA=new HashSet<>();

    // @ManyToOne(cascade = CascadeType.ALL) //或cascade ={CascadeType.PERSIST,CascadeType.MERGE},只有PERSIST会报错
    // @JoinColumn
    // private A parentA;
    public void testMoreLayers() {
        // 测试保存
        A a1 = A.builder().id(1).name("a1").build();
        A a2 = A.builder().id(2).name("a2").parentA(a1).build();
        aDao.save(a2);

        // 测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        Optional<A> findById2 = aDao.findById(2);
        A find2 = findById2.get();
        System.out.println(find1);
        //System.out.println(find1.getChildrenA()); //这里直接查的话,只有fetch = FetchType.EAGER且不加@Transactional的时候才可以查到,其他情况都会报错
        System.out.println(find2);

    }

    @Transactional
    public void testMoreLayers2() {
        // 测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        Optional<A> findById2 = aDao.findById(2);
        A find2 = findById2.get();
        System.out.println(find1);
        System.out.println(find1.getChildrenA());   //如果在另一个方法中查询,懒加载就会生效
        System.out.println(find2);

    }
}
