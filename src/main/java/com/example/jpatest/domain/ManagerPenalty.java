package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class ManagerPenalty {

    @Id @GeneratedValue
    @Column(name = "manager_penalty_seq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "manager_seq")
    private Manager manager;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "compensation_seq")
    private Compensation compensation;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "order_seq")
    private Order order;

    private Long compensateExpense;

    @Enumerated(EnumType.STRING)
    private PenaltyStatus penaltyStatus;

    private Long penaltyExpense;

    private String appealContents;

    private String penaltyContents;

    private LocalDateTime regDate;
}
