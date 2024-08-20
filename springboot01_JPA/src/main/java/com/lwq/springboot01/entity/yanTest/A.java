package com.lwq.springboot01.entity.yanTest;

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
@Table(name = "t_a")
// @ToString(exclude = { "bSet", "childrenA" })
// @EqualsAndHashCode(exclude = { "bSet", "childrenA" })
@ToString(exclude = { "parentA" })
@EqualsAndHashCode(exclude = { "parentA" })
public class A {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "a")
    private Set<B> bSet = new HashSet<>();

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentA", cascade = CascadeType.ALL)
    private Set<A> childrenA = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private A parentA;
}
