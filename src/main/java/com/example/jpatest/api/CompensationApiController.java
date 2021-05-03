package com.example.jpatest.api;


import com.example.jpatest.domain.Compensation;
import com.example.jpatest.service.CompensationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CompensationApiController {

    private final CompensationService compensationService;

    @PostMapping("/api/v1/compensations")
    public CreateCompensationResponse saveCompensationV1(@RequestBody @Valid Compensation compensation) {
        Long insert = compensationService.insert(compensation);
        return new CreateCompensationResponse(insert);
    }

    @PostMapping("/api/v2/compensations")
    public CreateCompensationResponse saveCompensationV2(@RequestBody @Valid CreateCompensationRequest request) {

        Compensation compensation = new Compensation();
        compensation.setId(request.getId());

        compensationService.insert(compensation);
        return new CreateCompensationResponse();
    }

    @Data
    static class CreateCompensationRequest {
        private Long id;
    }


    @Data
    static class CreateCompensationResponse {
        private Long id;

        public CreateCompensationResponse(Long id) {
            this.id = id;
        }
    }

}
