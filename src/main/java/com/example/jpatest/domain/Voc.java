package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Voc {

    @Id @GeneratedValue
    @Column(name = "voc_seq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "order_seq")
    private Order order;

    @OneToOne(mappedBy = "voc",fetch = LAZY)
    private Compensation compensation;

    private String vocResponsibility;

    private String vocNote;

    private Long sellerCost;

    private Long manufacturingCost;

    private Long deliveryCost;

    private Long compensateExpense;

    private LocalDateTime regDate;


    public static Voc createVoc(Order order) {
        Voc voc = new Voc();

        voc.setOrder(order);
        voc.setVocResponsibility(voc.getVocResponsibility());
        voc.setVocNote(voc.getVocNote());
        voc.setSellerCost(voc.getSellerCost());
        voc.setManufacturingCost(voc.getManufacturingCost());
        voc.setDeliveryCost(voc.getDeliveryCost());
        voc.setCompensateExpense(voc.getCompensateExpense());
        voc.setRegDate(LocalDateTime.now());

        return voc;

    }
}
