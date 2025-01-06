package com.lwq.jk1.j00_hello_algo;

import static org.mockito.ArgumentMatchers.longThat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TreeTest {
    class TreeNode {
        int val; // 节点值
        TreeNode left; // 左子节点引用
        TreeNode right; // 右子节点引用

        TreeNode(int x) {
            val = x;
        }
    }

    /* 层序遍历 */
    List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 队列出队
            list.add(node.val); // 保存节点值
            if (node.left != null)
                queue.offer(node.left); // 左子节点入队
            if (node.right != null)
                queue.offer(node.right); // 右子节点入队
        }
        return list;
    }

    /* 前序遍历 */
    void preOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        // 访问优先级：根节点-> 左子树-> 右子树
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    @Test
    public void a12() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        List<Integer> levelOrder = levelOrder(n1);
        System.out.println("层级遍历" + levelOrder);
        List<Integer> preOrderRes = new ArrayList<>();
        preOrder(n1, preOrderRes);
        System.out.println("前序遍历" + preOrderRes);
    }
}
