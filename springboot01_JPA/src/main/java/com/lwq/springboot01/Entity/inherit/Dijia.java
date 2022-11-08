package com.lwq.springboot01.Entity.inherit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
