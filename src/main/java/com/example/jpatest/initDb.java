package com.example.jpatest;

import com.example.jpatest.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class initDb {

    private final initService initService;

    @PostConstruct
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class initService {

        private final EntityManager em;

        public void dbInit1() {
            Voc voc = new Voc();
            voc.setVocResponsibility("매니저");
            voc.setVocNote("오배송");
            voc.setSellerCost(10000L);
            voc.setManufacturingCost(7000L);
            voc.setDeliveryCost(2000L);
            voc.setCompensateExpense(9000L);
            voc.setRegDate(LocalDateTime.now());

            em.persist(voc);


        }
    }

}


