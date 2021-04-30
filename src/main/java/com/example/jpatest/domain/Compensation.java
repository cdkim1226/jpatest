package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Compensation {

    @Id @GeneratedValue
    @Column(name = "compensation_seq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "order_seq")
    private Order order;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "voc_seq")
    private Voc voc;

    @Enumerated(EnumType.STRING)
    private ProcessStatus processStatus;

    private LocalDateTime regDate;

    /*연관관계 편의 메소드*/
    public void setVoc(Voc voc) {
        this.voc = voc;
        voc.setCompensation(this);
    }

    public static Compensation createCompensation(Voc voc, Order order) {
        Compensation compensation = new Compensation();

        compensation.setVoc(voc);
        compensation.setOrder(order);
        compensation.setProcessStatus(ProcessStatus.COMP);
        compensation.setRegDate(LocalDateTime.now());

        return compensation;

    }

}
