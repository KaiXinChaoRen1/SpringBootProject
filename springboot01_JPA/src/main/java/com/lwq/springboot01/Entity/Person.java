package com.lwq.springboot01.Entity;


import lombok.*;


import javax.persistence.*;

//JPA需要实体类有空参构造,使用BUilder需要三件套:@Builder,@AllArgsConstructor,@NoArgsConstructor
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

}
