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
@Table(name = "lwq_person")
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

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
