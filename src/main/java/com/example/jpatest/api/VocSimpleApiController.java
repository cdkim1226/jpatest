package com.example.jpatest.api;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.ProcessStatus;
import com.example.jpatest.domain.Voc;
import com.example.jpatest.repository.CompensationRepository;
import com.example.jpatest.repository.VocRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Proc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class VocSimpleApiController {

    private final VocRepository vocRepository;
    private final CompensationRepository compensationRepository;

    @GetMapping("/api/v1/simple-voc")
    public List<SimpleVocDto> vocV1() {
        List<Voc> voc = vocRepository.findAll();
        List<SimpleVocDto> result = voc.stream()
                .map(v -> new SimpleVocDto(v))
                .collect(Collectors.toList());

        return result;
    }

    @Data
    static class SimpleVocDto {
        private Long Id;
        private String vocResponsibility;
        private String vocNote;
        private Long sellerCost;
        private Long manufacturingCost;
        private Long deliveryCost;
        private Long compensateExpense;
        private LocalDateTime regDate;

        public SimpleVocDto(Voc voc) {
            Id = voc.getId();
            vocResponsibility = voc.getVocResponsibility();
            vocNote = voc.getVocNote();
            sellerCost = voc.getSellerCost();
            manufacturingCost = voc.getManufacturingCost();
            deliveryCost = voc.getDeliveryCost();
            compensateExpense = voc.getCompensateExpense();
            regDate = voc.getRegDate();
        }
    }

}
