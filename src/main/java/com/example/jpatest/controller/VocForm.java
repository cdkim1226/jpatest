package com.example.jpatest.controller;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class VocForm {

    private String vocResponsibility;

    private String vocNote;

    private Long sellerCost;

    private Long manufacturingCost;

    private Long deliveryCost;

    private Long compensateExpense;

    private LocalDateTime regDate;

}
