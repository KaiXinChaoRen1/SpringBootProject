package com.lwq.springboot01.Entity.tree;


import com.sun.source.tree.IdentifierTree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import xin.altitude.cms.common.lang.ITreeEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 引入不知名作者写的工具类实现
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tree_subject")
public class Subject implements ITreeEntity<String> {
    @Id
    private String uuid;
    private String subjectName;
    private String fatherUuid;



    @Override
    public String getId() {
        return uuid;
    }

    @Override
    public String getName() {
        return subjectName;
    }

    @Override
    public String getParentId() {
        return fatherUuid;
    }
}
