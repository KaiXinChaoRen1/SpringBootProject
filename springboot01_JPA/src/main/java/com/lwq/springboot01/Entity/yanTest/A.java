package com.lwq.springboot01.Entity.yanTest;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name="t_a")
@ToString(exclude = {"bSet","childrenA"})
@EqualsAndHashCode(exclude = {"bSet","childrenA"})
public class A {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "a")
    private Set<B> bSet=new HashSet<>();

    //下面两个用于多层级测试
    //把A当作目录,则A拥有其他子A
    @Builder.Default
    @OneToMany(mappedBy = "parentA")
    private Set<A> childrenA=new HashSet<>();

    //把A当作目录,则A拥有一个父A
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn
    private  A  parentA;
}
