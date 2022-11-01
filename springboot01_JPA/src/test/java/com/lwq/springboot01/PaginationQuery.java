package com.lwq.springboot01;

import com.lwq.springboot01.Entity.Person;
import com.lwq.springboot01.dao.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PaginationQuery {
    @Autowired
    PersonRepository pr;

    /**
     * 添加数据
     */
    @Test
    public void name0() {
        ArrayList<Person> personList = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            personList.add(new Person("a" + i));
        }
        pr.saveAll(personList);

    }

    /**
     * 分页查询所有(分页从第0页开始)
     */
    @Test
    public void name1() {
        Page<Person> all = pr.findAll(PageRequest.of(0, 4));
        System.out.println(all.getTotalElements()); //总数据条数
        System.out.println(all.getTotalPages());    //总页数
        System.out.println(all.getNumber());        //当前页数
        System.out.println(all.getContent());       //当前页的数据集合
    }


//    /**
//     * 条件查询带分页(复杂写法)
//     */
//    @Test
//    public void name2(){
//        List<Person> aaa = pageSelectQuery(PageRequest.of(1, 2), "aaa");
//        System.out.println(aaa);
//    }
//
//    public List<Person> pageSelectQuery(Pageable pageable,String name){
//        Specification<Person> spec=new Specification<Person>() {
//            @Override
//            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//                Path<Object> namePara = root.get("name");
//                Predicate nameEqual = criteriaBuilder.equal(namePara.as(String.class), name);
//                return nameEqual;
//            }
//        };
//        return getPageSelectQuery(spec,pageable);
//    }
//
//    private List<Person> getPageSelectQuery(Specification<Person> spec, Pageable pageable) {
//        Page all = pr.findAll(spec, pageable);
//        return all.getContent();
//    }

    /**
     * 条件查询带分页简单写法
     */
    @Test
    public void name2() {
        List<Person> aaa = pageSelectQuery(PageRequest.of(0, 2), "bbb");
        System.out.println(aaa);
    }

    private List<Person> pageSelectQuery(Pageable pageable, String name) {
        Page all = pr.findAll((root, cq, cb) -> cq.where(cb.equal(root.get("name"), name)).getRestriction(), pageable);
        return all.getContent();
    }


}
