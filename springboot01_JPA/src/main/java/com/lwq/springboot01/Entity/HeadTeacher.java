package com.lwq.springboot01.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lwq_head_teacher")
public class HeadTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String  name;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "ht") //只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性；
    private Set<Student> students = new HashSet<>();


}
