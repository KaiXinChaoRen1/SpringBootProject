package com.lwq.springboot01.Entity.Test;

import java.util.Set;

import javax.persistence.*;

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

    @OneToMany(mappedBy = "a",fetch = FetchType.EAGER)
    private Set<B> bSet;

    //把A当作目录,则A拥有其他子A
    @OneToMany(mappedBy = "parentA",fetch = FetchType.EAGER)
    private Set<A> childrenA;

    //把A当作目录,则A拥有一个父A
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private  A  parentA;
}
