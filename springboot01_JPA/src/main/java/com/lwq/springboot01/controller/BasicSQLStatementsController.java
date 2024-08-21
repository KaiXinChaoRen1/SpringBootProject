package com.lwq.springboot01.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.dao.mySpecification.MySpecifications;
import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "基础SQL语句测试")
@RestController
public class BasicSQLStatementsController {

    @Resource
    PersonRepository personRepository;

    @ApiOperation(value = "添加数据,批量插入")
    @GetMapping("/addData")
    public Object addData() {

        List<Person> arrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Person person = new Person("lwq" + i, i);
            personRepository.save(person);
            arrayList.add(person);
        }
        personRepository.saveAll(arrayList);

        return "success";

    }

    @ApiOperation(value = "分页查询")
    @GetMapping("/pagedQuery")
    public Object pagedQuery(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortProperty,
            @RequestParam(defaultValue = "asc") String sortDirection) {

        Sort.Direction direction = Sort.Direction.ASC;
        if (sortDirection.equals("desc")) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, sortProperty);

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Person> all = personRepository.findAll(pageable);

        return all;
    }

    @ApiOperation(value = "分页查询指定属性")
    @GetMapping("/pagedQueryWhere")
    public Object pagedQueryWhere(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortProperty,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "name") String filterProperty,
            @RequestParam(defaultValue = "hehe") String filterValue) {

        Sort.Direction direction = Sort.Direction.ASC;
        if (sortDirection.equals("desc")) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, sortProperty);

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Person> spec = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(filterProperty),
                filterValue);
        Page<Person> all = personRepository.findAll(spec, pageable);

        return all;
    }

    @ApiOperation(value = "Specification进阶")
    @GetMapping("/specificationAdvanced ")
    public Object specificationAdvanced(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortProperty,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "name") String likeProperty,
            @RequestParam(defaultValue = "lwq") String likeValue,
            @RequestParam(defaultValue = "age") String lessProperty,
            @RequestParam(defaultValue = "18") String lessValue) {

        Sort.Direction direction = Sort.Direction.ASC;
        if (sortDirection.equals("desc")) {
            direction = Sort.Direction.DESC;
        }

        Sort sort = Sort.by(direction, sortProperty);

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Person> andSpecification = Specification
                .where(MySpecifications.like(likeProperty, likeValue))

                .or(MySpecifications.lessThan(lessProperty, lessValue));

        Page<Person> all = personRepository.findAll(andSpecification, pageable);

        return all;
    }
}
