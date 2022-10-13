package com.lwq.springboot01.Entity.Test;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@ToString(exclude = {"bSet"})
@EqualsAndHashCode(exclude = {"bSet"})
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    private String name;

    @OneToMany(mappedBy = "a")
    private Set<B> bSet;
}
