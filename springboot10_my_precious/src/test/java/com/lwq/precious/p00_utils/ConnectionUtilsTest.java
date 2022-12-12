package com.lwq.precious.p00_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ConnectionUtilsTest {

    @Test
    public void name() {
        // isEmpty()
        boolean emptyFlag = CollectionUtils.isEmpty(new HashSet<>());
        System.out.println(emptyFlag);
        // containsAny()
        boolean containsAnyFlag = CollectionUtils.containsAny(new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(3, 4, 5)));
        System.out.println(containsAnyFlag);
        // findFirstMatch()
        Integer findFirstMatch = CollectionUtils.findFirstMatch(new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(10, 20, 3, 4, 5)));
        System.out.println(findFirstMatch);
        // firstElement()
        TreeSet<Integer> treeSet = new TreeSet<>(new ArrayList<>(Arrays.asList(9, 27, 8)));
        System.out.println(treeSet);
        Integer firstElement = CollectionUtils.firstElement(treeSet);
        System.out.println(firstElement);
    }
}
