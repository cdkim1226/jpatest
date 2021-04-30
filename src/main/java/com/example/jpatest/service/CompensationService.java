package com.example.jpatest.service;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.Order;
import com.example.jpatest.domain.Voc;
import com.example.jpatest.repository.CompensationRepository;
import com.example.jpatest.repository.OrderRepository;
import com.example.jpatest.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompensationService {


    private final VocRepository vocRepository;
    private final OrderRepository orderRepository;
    private final CompensationRepository compensationRepository;

    public Long insert(Compensation compensation) {
        compensationRepository.save(compensation);
        return compensation.getId();
    }

    public List<Compensation> findCompensationList() {
        return compensationRepository.findAll();
    }

    public Compensation findOne(Long compensationSeq) {
        return compensationRepository.findOne(compensationSeq);
    }

    // 업데이트 시 변경 감지 사용
    @Transactional
    public Compensation updateCompensation(Long compensationSeq, Voc param) {
        Compensation findCompensation = compensationRepository.findOne(compensationSeq);
//        findCompensation.setVoc(param.getVocNote());
        return findCompensation;
    }

    @Transactional
    public Long compensation(Long vocSeq, Long orderSeq, int count) {

        Voc voc = vocRepository.findOne(vocSeq);
        Order order = orderRepository.findOne(orderSeq);

        Compensation compensation = Compensation.createCompensation(voc, order);

        compensationRepository.save(compensation);

        return compensation.getId();
    }
}
