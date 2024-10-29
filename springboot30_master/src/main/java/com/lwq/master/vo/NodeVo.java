package com.lwq.master.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeVo {
    String name;
    String uri;
    String descripution;

    public NodeVo(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

}
