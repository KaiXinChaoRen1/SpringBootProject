package com.lwq.springboot01.entity.transactionTestEntity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "lwq_account")
public class Account {
    @Id
    Long id;

    @Column
    Long accountNum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    User user;
}
