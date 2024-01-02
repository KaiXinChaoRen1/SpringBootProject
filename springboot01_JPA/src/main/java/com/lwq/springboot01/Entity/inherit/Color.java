package com.lwq.springboot01.entity.inherit;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lwq_dijia_color")
public class Color {

    @Id
    String uuid;

    String value;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "color")
    private Dijia dijia;

    @Override
    public String toString() {
        return "Color [uuid=" + uuid + ", name=" + value + "]";
    }

    

}
