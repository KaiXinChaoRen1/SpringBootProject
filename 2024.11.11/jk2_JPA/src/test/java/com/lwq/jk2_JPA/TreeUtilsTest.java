package com.lwq.jk2_JPA;

import com.lwq.jk2_JPA.dao.treeRepository.SubjectRepository;
import com.lwq.jk2_JPA.entity.treeUtils.Subject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xin.altitude.cms.common.entity.TreeNode;
import xin.altitude.cms.common.util.TreeUtils;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TreeUtilsTest {

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
