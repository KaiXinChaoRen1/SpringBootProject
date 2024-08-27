package com.lwq.springboot11.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AsnycTaskVO {
    private String taskId;
    @Builder.Default
    private Integer progress = 0;
    @Builder.Default
    private Boolean done = false;
    @Builder.Default
    private Object result = null;
    @Builder.Default
    private String progressMessage = "";
}