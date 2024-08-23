package com.lwq.springboot01.entity.schoolstory;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.*;

//JPA需要实体类有空参构造,使用Builder需要三件套:@Builder,@AllArgsConstructor,@NoArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "t_person", indexes = {
        // 联合唯一索引
        @Index(name = "uniqueidx_unique1_unique2", columnList = "c_unique1, c_unique2", unique = true) })
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birthday")
    private LocalDateTime birthday;

    @Column(name = "c_unique1")
    private String unique1;

    @Column(name = "c_unique2")
    private String unique2;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
