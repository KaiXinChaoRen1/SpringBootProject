package com.lwq.springboot01.Entity.TransactionTestEntity;

import javax.persistence.Column;
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
@Table(name = "lwq_user")
public class User {
    @Id
    Long id;

    @Column
    String name;

    @OneToOne(mappedBy = "user")
    Account account;
}
