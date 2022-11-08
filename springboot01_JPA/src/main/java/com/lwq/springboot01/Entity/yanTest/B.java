package com.lwq.springboot01.Entity.yanTest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name="t_b")
public class B {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private A a;
}
