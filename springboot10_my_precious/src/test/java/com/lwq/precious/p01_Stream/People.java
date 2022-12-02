package com.lwq.precious.p01_Stream;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class People {
    String sex;
    String name;
    Integer age;
    Integer salary;

    public People(String name, Integer age, Integer salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
