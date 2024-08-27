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

    public void testMoreLayers() {
        // 测试保存
        A a1 = A.builder().id(1).name("a1").build();
        aDao.save(a1);// 必须要先保存父节点
        A a2 = A.builder().id(2).name("a2").parentA(a1).build();
        aDao.save(a2);

        // 测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        Optional<A> findById2 = aDao.findById(2);
        A find2 = findById2.get();
        System.out.println(find1);
        System.out.println(find1.getChildrenA());
        System.out.println(find2);

    }

    @Transactional
    public void testMoreLayerss() {
        // 测试保存
        A a1 = A.builder().id(1).name("a1").build();
        aDao.save(a1);// 必须要先保存父节点
        A a2 = A.builder().id(2).name("a2").parentA(a1).build();
        aDao.save(a2);

        // 测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        Optional<A> findById2 = aDao.findById(2);
        A find2 = findById2.get();
        System.out.println(find1);
        System.out.println(find1.getChildrenA());
        System.out.println(find2);

    }

    @Transactional
    public A testMoreLayers2() {
        // 测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        return find1;

    }

    @Transactional
    public void deleteParent() {
        // 测试查询
        Optional<A> findById = aDao.findById(1);
        A find1 = findById.get();
        aDao.delete(find1);

    }

    @Transactional
    public void deleteChild() {
        // 测试查询
        Optional<A> findById = aDao.findById(2);
        A find1 = findById.get();
        aDao.delete(find1);

    }

    @Transactional
    public void saveAndFindInOneTransaction() {

    }
}
