package com.lwq.springboot01.Entity.schoolstory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 1.规律：凡是双向关联，mapped必设，因为根本都没必要在2个表中都存在一个外键关联，在数据库中只要定义一边就可以了
 * a) 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性；
 * b) mappedBy标签一定是定义在the owned side(被拥有方的)，他指向the owning side(拥有方)；
 * c) mappedBy的含义，应该理解为，拥有方能够自动维护 跟被拥有方的关系；
 * 当然，如果从被拥有方，通过手工强行来维护拥有方的关系也是可以做到的。
 * d) mappedBy跟JoinColumn/JoinTable总是处于互斥的一方，可以理解为正是由于拥有方的关联被拥有方的字段存在，拥有方才拥有了被 拥有方。mappedBy这方定义的JoinColumn/JoinTable总是失效的，不会建立对应的字段或者表
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lwq_student_id")
public class StudentId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer StudentIdNumber;
    @Column
    private String other;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sid"/*, optional = false*/)//optional = false,学生证必须有对应的学生
    //@JoinColumn
    private Student student;

//    @Override
//    public String toString() {
//        return "StudentId{" +
//                "id=" + id +
//                ", StudentIdNumber=" + StudentIdNumber +
//                ", other='" + other + '\'' +
//                ", Student='"+student.getName()+
//                '}';
//    }
}
