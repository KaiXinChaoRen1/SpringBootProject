package com.lwq.precious.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    private void cry() {
        System.out.println("我在狗叫,芜湖~");
    }
    public void learning() {
        System.out.println("我叫"+name+"我在学习,芜湖~");
    }
}
