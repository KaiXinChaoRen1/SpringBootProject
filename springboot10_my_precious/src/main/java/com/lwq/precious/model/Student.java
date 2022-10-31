package com.lwq.precious.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    // @NotBlank(message = "不能没有名字")
    // String name;
    // @NotBlank(message = "不能没有密码")
    // String studentId;

    @NotNull(message = "不能没有名字")
    String name;
    @NotNull(message = "不能没有密码")
    String studentId;
    @NotEmpty(message = "选课不能为空")
    List<String> courseSelection;
}
