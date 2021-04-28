package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Compensation {

    @Id @GeneratedValue
    @Column(name = "compensation_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_seq")
    private Order order;

    @OneToOne
    @JoinColumn(name = "voc_seq")
    private Voc voc;

    @Enumerated(EnumType.STRING)
    private ProcessStatus processStatus;

    private LocalDateTime regDate;
}
