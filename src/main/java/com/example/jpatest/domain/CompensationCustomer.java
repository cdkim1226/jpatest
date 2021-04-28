package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class CompensationCustomer {

    @Id @GeneratedValue
    @Column(name = "compensation_customer_seq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "customer_seq")
    private Customer customer;

    private Long sellerCost;

    private Long manufacturingCost;

    private Long compensateExpense;

    private LocalDateTime regDate;
}
