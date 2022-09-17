package com.lwq.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.lwq.domain.User"};  //根据字符串数组，导入多个bean，所以我们可以利用外部配置文件，去动态加载,而springboot也确实是这么做的
    }
}
