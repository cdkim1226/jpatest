package com.example.jpatest.api;


import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.ProcessStatus;
import com.example.jpatest.domain.Voc;
import com.example.jpatest.repository.CompensationRepository;
import com.example.jpatest.repository.compensation.simplequery.CompensationSimpleQueryRepository;
import com.example.jpatest.repository.compensation.simplequery.SimpleCompensationQueryDto;
import com.example.jpatest.service.CompensationService;
import com.example.jpatest.service.VocService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CompensationSimpleApiController {

    private final CompensationService compensationService;
    private final VocService vocService;
    private final CompensationRepository compensationRepository;
    private final CompensationSimpleQueryRepository compensationSimpleQueryRepository;

//    @PostMapping("/api/v1/compensations")
//    public CreateCompensationResponse saveCompensationV1(@RequestBody @Valid Compensation compensation) {
//        Long insert = compensationService.insert(compensation);
//        return new CreateCompensationResponse(insert);
//    }
//
//    @PostMapping("/api/v2/compensations")
//    public CreateCompensationResponse saveCompensationV2(@RequestBody @Valid CreateCompensationRequest request) {
//
//        Compensation compensation = new Compensation();
//        compensation.setId(request.getId());
//
//        Long id = compensationService.insert(compensation);
//        return new CreateCompensationResponse(id);
//    }

    @GetMapping("/api/v1/voc")
    public List<Voc> vocV1() {
        return vocService.findVocList();
    }

    @GetMapping("/api/v2/voc")
    public Result vocV2() {
        List<Voc> findVoc = vocService.findVocList();
        List<VocDto> collect = findVoc.stream()
                .map(v -> new VocDto(v.getVocResponsibility()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class VocDto {
        private String vocResponsibility;
    }



    @PostMapping("/api/v2/voc")
    public CreateVocResponse saveVocV2(@RequestBody @Valid CreateVocRequest request) {

        Voc voc = new Voc();
        voc.setVocResponsibility(request.getVocResponsibility());

        Long id = vocService.insert(voc);
        return new CreateVocResponse(id);
    }

    @PutMapping("/api/v2/voc/{id}")
    public UpdateVocResponse updateVocV2(@PathVariable("id") Long id,
                                         @RequestBody @Valid UpdateVocRequest request) {

        vocService.update(id, request.getVocResponsibility());
        Voc findVoc = vocService.findOne(id);
        return new UpdateVocResponse(findVoc.getId(), findVoc.getVocResponsibility());
    }

    @Data
    static class UpdateVocRequest {
        private String vocResponsibility;
    }

    @Data
    @AllArgsConstructor
    static class UpdateVocResponse {
        private Long id;
        private String vocResponsibility;
    }



    @Data
    static class CreateVocRequest {
        private String vocResponsibility;
    }

    @Data
    static class CreateVocResponse {
        private Long id;

        public CreateVocResponse(Long id) {
            this.id = id;
        }
    }


    @GetMapping("/api/v2/simple-compensation")
    public List<SimpleCompensationDto> compensationV2() {
        List<SimpleCompensationDto> result = compensationRepository.findAll().stream()
                .map(c -> new SimpleCompensationDto(c))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v3/simple-compensation")
    public List<SimpleCompensationDto> compensationV3() {
        List<Compensation> compensations = compensationRepository.findAllWithVocOrder();
        List<SimpleCompensationDto> result = compensations.stream()
                .map(c -> new SimpleCompensationDto(c))
                .collect(Collectors.toList());

        return result;
    }

    @GetMapping("/api/v4/simple-compensation")
    public List<SimpleCompensationQueryDto> compensationV4() {
        return compensationRepository.findCompensationDtos();
    }

    @Data
    static class SimpleCompensationDto {
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

        public SimpleCompensationDto(Compensation compensation) {
            id = compensation.getId();
            orderNum = compensation.getOrder().getOrderNum();
            boxCount = compensation.getOrder().getBoxCount();
            processStatus = compensation.getProcessStatus();
            vocResponsibility = compensation.getVoc().getVocResponsibility();
            vocNote = compensation.getVoc().getVocNote();
            sellerCost = compensation.getVoc().getSellerCost();
            manufacturingCost = compensation.getVoc().getManufacturingCost();
            deliveryCost = compensation.getVoc().getDeliveryCost();
            compensateExpense = compensation.getVoc().getCompensateExpense();
            regDate = compensation.getRegDate();
        }
    }






//    @Data
//    static class CreateCompensationRequest {
//        private Long id;
//    }
//
//
//    @Data
//    static class CreateCompensationResponse {
//        private Long id;
//
//        public CreateCompensationResponse(Long id) {
//            this.id = id;
//        }
//    }

}
