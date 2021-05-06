package com.example.jpatest.repository.compensation.simplequery;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.ProcessStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SimpleCompensationQueryDto {
    private Long id;
    private String orderNum;
    private Long boxCount;
    private ProcessStatus processStatus;
    private String vocResponsibility;
    private String vocNote;
    private Long sellerCost;
    private Long manufacturingCost;
    private Long deliveryCost;
    private Long compensateExpense;
    private LocalDateTime regDate;

    public SimpleCompensationQueryDto(Long id, String orderNum, Long boxCount, ProcessStatus processStatus, String vocResponsibility, String vocNote,
                                      Long sellerCost, Long manufacturingCost, Long deliveryCost, Long compensateExpense, LocalDateTime regDate) {
        this.id = id;
        this.orderNum = orderNum;
        this.boxCount = boxCount;
        this.processStatus = processStatus;
        this.vocResponsibility = vocResponsibility;
        this.vocNote = vocNote;
        this.sellerCost = sellerCost;
        this.manufacturingCost = manufacturingCost;
        this.deliveryCost = deliveryCost;
        this.compensateExpense = compensateExpense;
        this.regDate = regDate;
    }
}