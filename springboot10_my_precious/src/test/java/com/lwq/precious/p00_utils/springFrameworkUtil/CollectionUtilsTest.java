package com.lwq.precious.p00_utils.springFrameworkUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CollectionUtilsTest {

        /**
         * containsAny
         */
        @Test
        public void name2() {
                boolean containsAnyFlag = CollectionUtils.containsAny(new ArrayList<>(Arrays.asList(1, 2, 3)),
                                null);
                System.out.println(containsAnyFlag);

                boolean containsAnyFlag2 = CollectionUtils.containsAny(new ArrayList<>(Arrays.asList(1, 2, 3)),
                                new ArrayList<>());
                System.out.println(containsAnyFlag2);

                boolean containsAnyFlag3 = CollectionUtils.containsAny(null,
                                new ArrayList<>());
                System.out.println(containsAnyFlag3);

                boolean containsAnyFlag4 = CollectionUtils.containsAny(new ArrayList<>(Arrays.asList(1, 2, 3)),
                                new ArrayList<>(Arrays.asList(1, 9, 8)));
                System.out.println(containsAnyFlag4);
        }

        /**
         * import org.springframework.util.CollectionUtils;
         */
        @Test
        public void name() {
                // isEmpty()
                boolean emptyFlag = CollectionUtils.isEmpty(new HashSet<>());
                System.out.println(emptyFlag);

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

        // // 判断 List/Set 是否为空
        // boolean isEmpty(Collection<?> collection)
        // // 判断 Map 是否为空
        // boolean isEmpty(Map<?,?> map)
        // // 判断 List/Set 中是否包含某个对象
        // boolean containsInstance(Collection<?> collection, Object element)
        // // 以迭代器的方式，判断 List/Set 中是否包含某个对象
        // boolean contains(Iterator<?> iterator, Object element)
        // // 判断 List/Set 是否包含某些对象中的任意一个
        // boolean containsAny(Collection<?> source, Collection<?> candidates)
        // // 判断 List/Set 中的每个元素是否唯一。即 List/Set 中不存在重复元素
        // boolean hasUniqueObject(Collection<?> collection)

        // // 将 Array 中的元素都添加到 List/Set 中
        // <E> void mergeArrayIntoCollection(Object array, Collection<E> collection)
        // // 将 Properties 中的键值对都添加到 Map 中
        // <K,V> void mergePropertiesIntoMap(Properties props, Map<K,V> map)
        // // 返回 List 中最后一个元素
        // <T> T lastElement(List<T> list)
        // // 返回 Set 中最后一个元素
        // <T> T lastElement(Set<T> set)
        // // 返回参数 candidates 中第一个存在于参数 source 中的元素
        // <E> E findFirstMatch(Collection<?> source, Collection<E> candidates)
        // // 返回 List/Set 中指定类型的元素。
        // <T> T findValueOfType(Collection<?> collection, Class<T> type)
        // // 返回 List/Set 中指定类型的元素。如果第一种类型未找到，则查找第二种类型，以此类推
        // Object findValueOfType(Collection<?> collection, Class<?>[] types)
        // // 返回 List/Set 中元素的类型
        // Class<?> findCommonElementType(Collection<?> collection)
}
