package com.lwq.precious.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MyJsonUser {
    private String name;
    private int age;
    @Singular("addHobby")
    private List<String> hobby;
    private LocalDateTime  birthday;
}
