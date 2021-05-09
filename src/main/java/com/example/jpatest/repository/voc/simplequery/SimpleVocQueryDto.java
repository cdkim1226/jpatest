package com.example.jpatest.repository.voc.simplequery;

import com.example.jpatest.domain.Voc;
import lombok.Data;

import java.time.LocalDateTime;

    @Data
    public class SimpleVocQueryDto {
        private Long Id;
        private String orderNum;
        private String vocResponsibility;
        private String vocNote;
        private Long sellerCost;
        private Long manufacturingCost;
        private Long deliveryCost;
        private Long compensateExpense;
        private LocalDateTime regDate;

        public SimpleVocQueryDto(Long id, String orderNum, String vocResponsibility, String vocNote,
                                 Long sellerCost, Long manufacturingCost, Long deliveryCost, Long compensateExpense, LocalDateTime regDate) {
            this.Id = id;
            this.orderNum = orderNum;
            this.vocResponsibility = vocResponsibility;
            this.vocNote = vocNote;
            this.sellerCost = sellerCost;
            this.manufacturingCost = manufacturingCost;
            this.deliveryCost = deliveryCost;
            this.compensateExpense = compensateExpense;
            this.regDate = regDate;
        }
    }
