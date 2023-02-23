package com.lwq.precious.p06_Collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lwq.precious.model.MyJsonUser;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SetTest {
    /**
     * TreeSet
     */
    @Test
    public void name1() {
        TreeSet<MyJsonUser> treeSet = new TreeSet<MyJsonUser>(new Comparator<MyJsonUser>() {
            @Override
            public int compare(MyJsonUser u1, MyJsonUser u2) {
                return u1.getAge() < u2.getAge() ? -1 : 1;
            }
        });

        MyJsonUser user1 = MyJsonUser.builder().name("李文强").age(23).build();
        MyJsonUser user2 = MyJsonUser.builder().name("文强李").age(24).build();
        treeSet.add(user2);
        treeSet.add(user1);
        System.out.println(treeSet);

    }

    @Test
    public void name2() {
        System.out.println("ABC".compareTo("BCD"));
        System.out.println("阿龙".compareTo("波子"));
    }
}
