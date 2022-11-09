package com.lwq.springboot01.Entity.schoolstory;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lwq_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL,optional=true)//默认也是optional=true 一个学生可以没有学号,类比一个人可以没有身份证 =false则必须有关联
    @JoinColumn
    private StudentId sid;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private HeadTeacher ht;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Course> courseSet;

//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                //", sid=" + sid.getStudentIdNumber() +
//               // ", ht=" + ht.getName() +
//                '}';
//    }
}
