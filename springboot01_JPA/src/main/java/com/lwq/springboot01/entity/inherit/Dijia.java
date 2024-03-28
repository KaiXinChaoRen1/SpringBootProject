package com.lwq.springboot01.entity.inherit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
//@MappedSuperclass TODO 这个还没学
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lwq_dijia")
public class Dijia {
    @Id
    String uuid;
    Integer power;
    Integer speed;

    @OneToOne(cascade = CascadeType.ALL)
    private Color color;
}
