package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Voc {

    @Id @GeneratedValue
    @Column(name = "voc_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_seq")
    private Order order;

    private String vocResponsibility;

    private String vocNote;

    private Long sellerCost;

    private Long manufacturingCost;

    private Long deliveryCost;

    private Long compensateExpense;

    private LocalDateTime regDate;
}
