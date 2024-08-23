package com.lwq.springboot01.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.springboot01.dao.mySpecification.MySpecifications;
import com.lwq.springboot01.dao.schoolRepository.PersonRepository;
import com.lwq.springboot01.entity.schoolstory.Person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "索引测试")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PersonRepository pr;

    @Autowired
    private IndexService indexService;

    @ApiOperation(value = "添加一条数据,可测试唯一索引")
    @PostMapping("/add")
    public ResponseEntity<String> add1ResponseEntity(@RequestBody Person person) {
        try {
            pr.save(person);
        } catch (Exception e) {
            return ResponseEntity.ok("添加失败" + e.getMessage());
        }
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "指定数量添加数据")
    @PostMapping("/add2")
    public ResponseEntity<String> add2(Integer num) {
        List<Person> arrayList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Person person = new Person();
            // person.setId(i);
            person.setIndexedUuid(UUID.randomUUID().toString() + i);
            person.setUnindexedUuid(UUID.randomUUID().toString() + i);
            arrayList.add(person);
        }
        pr.saveAll(arrayList);
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "指定数量添加数据,(事务中执行saveAll)")
    @PostMapping("/add22")
    public ResponseEntity<String> add22(Integer num) {
        indexService.addNum(num);
        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "指定数量添加数据,(EntityManager)")
    @PostMapping("/add222")
    public ResponseEntity<String> add222(Integer num) {

        List<Person> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Person person = new Person();
            person.setIndexedUuid(UUID.randomUUID().toString());
            person.setUnindexedUuid(UUID.randomUUID().toString());
            list.add(person);
        }
        indexService.batchInsert(list);

        return ResponseEntity.ok("添加成功");
    }

    @ApiOperation(value = "Specification查询数据")
    @PostMapping("/find")
    public ResponseEntity<Object> add3(String columnName, String uuid) {

        Specification<Person> spec = MySpecifications.equal(columnName, uuid);

        List<Person> all = pr.findAll(spec);

        return ResponseEntity.ok(all);
    }

}
