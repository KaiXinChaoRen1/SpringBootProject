package com.lwq.springboot01;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.springboot01.Entity.tree.Subject;
import com.lwq.springboot01.dao.treeRepository.SubjectRepository;

import xin.altitude.cms.common.entity.TreeNode;
import xin.altitude.cms.common.util.TreeUtils;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TreeTest {

    @Autowired
    private SubjectRepository sr;


    /**
     * 引入不知名作者写的工具类实现
     */
    @Test
    public void name0() {
        List<Subject> all = sr.findAll();

        List<TreeNode<String>> node = TreeUtils.createNode(all, "0000");

        System.out.println(node);


    }
}
