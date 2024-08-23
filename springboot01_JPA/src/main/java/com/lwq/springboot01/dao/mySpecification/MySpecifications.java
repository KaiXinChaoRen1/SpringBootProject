package com.lwq.springboot01.dao.mySpecification;

import org.springframework.data.jpa.domain.Specification;

import com.lwq.springboot01.entity.schoolstory.Person;

public class MySpecifications {

    public static Specification<Person> equal(String filterProperty, String filterValue) {

        Specification<Person> spec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(filterProperty),
                filterValue);

        return spec;
    }

    public static Specification<Person> like(String filterProperty, String filterValue) {

        Specification<Person> spec = (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(filterProperty),
                filterValue);

        return spec;
    }

    public static Specification<Person> lessThan(String filterProperty, String filterValue) {

        Specification<Person> spec = (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(
                root.get(filterProperty),
                filterValue);

        return spec;
    }

    public static Specification<Person> greaterThan(String filterProperty, String filterValue) {

        Specification<Person> spec = (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(
                root.get(filterProperty),
                filterValue);

        return spec;
    }
}
