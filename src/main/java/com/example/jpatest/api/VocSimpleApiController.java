package com.example.jpatest.api;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.Order;
import com.example.jpatest.domain.ProcessStatus;
import com.example.jpatest.domain.Voc;
import com.example.jpatest.repository.CompensationRepository;
import com.example.jpatest.repository.VocRepository;
import com.example.jpatest.repository.compensation.simplequery.SimpleCompensationQueryDto;
import com.example.jpatest.repository.voc.simplequery.SimpleVocQueryDto;
import com.example.jpatest.repository.voc.simplequery.VocSimpleQueryRepository;
import com.example.jpatest.service.VocService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Proc;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class VocSimpleApiController {

    private final VocSimpleQueryRepository vocSimpleQueryRepository;
    private final CompensationRepository compensationRepository;
    private final VocService vocService;


    @PostMapping("/api/v4/voc")
    public createVocResponse saveVocV2(@RequestBody @Valid CreateVocRequest request) {

        Voc voc = new Voc();
        Order order = new Order();
        voc.setOrder(order);
        voc.setVocResponsibility(request.getVocResponsibility());
        voc.setVocNote(request.getVocNote());
        voc.setSellerCost(request.getSellerCost());
        voc.setManufacturingCost(request.getManufacturingCost());
        voc.setDeliveryCost(request.getDeliveryCost());
        voc.setCompensateExpense(request.getCompensateExpense());
        voc.setRegDate(LocalDateTime.now());

        Long id = vocService.insert(voc);
        return new createVocResponse(id);
    }

    @GetMapping("/api/v4/simple-voc")
    public List<SimpleVocQueryDto> vocV4() {
        return vocSimpleQueryRepository.findVocDtos();
    }


    @Data
    static class CreateVocRequest {
        private String orderNum;
        private String vocResponsibility;
        private String vocNote;
        private Long sellerCost;
        private Long manufacturingCost;
        private Long deliveryCost;
        private Long compensateExpense;
        private LocalDateTime regDate;
        private Long orderSeq;

    }


    @Data
    static class createVocResponse {
        private Long id;

        public createVocResponse(Long id) {
            this.id = id;
        }
    }


}
