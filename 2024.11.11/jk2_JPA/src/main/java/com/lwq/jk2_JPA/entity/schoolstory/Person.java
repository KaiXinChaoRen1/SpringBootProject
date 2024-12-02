package com.lwq.jk2_JPA.entity.schoolstory;

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
        @Index(name = "uniqueidx_unique1_unique2", columnList = "c_unique1, c_unique2", unique = true),
        @Index(name = "idx_having_idx_uuid", columnList = "having_idx_uuid") })
public class Person {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY) //这种情况jpa不支持批量插入
    // private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    @SequenceGenerator(name = "seqGen", sequenceName = "seq", initialValue = 1)
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

    @Column(name = "having_idx_uuid")
    private String indexedUuid;

    @Column(name = "no_idx_uuid")
    private String unindexedUuid;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
