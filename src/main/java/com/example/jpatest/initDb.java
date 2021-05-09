package com.example.jpatest;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.Order;
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

//        public void dbInit1() {
//            Voc voc = new Voc();
//            voc.setVocResponsibility("매니저");
//            voc.setVocNote("오배송");
//            voc.setSellerCost(10000L);
//            voc.setManufacturingCost(7000L);
//            voc.setDeliveryCost(2000L);
//            voc.setCompensateExpense(9000L);
//            voc.setRegDate(LocalDateTime.now());
//            em.persist(voc);
//
//            Voc voc2 = new Voc();
//            voc2.setVocResponsibility("고객사");
//            voc2.setVocNote("제품불량");
//            voc2.setSellerCost(20000L);
//            voc2.setManufacturingCost(17000L);
//            voc2.setDeliveryCost(12000L);
//            voc2.setCompensateExpense(19000L);
//            voc2.setRegDate(LocalDateTime.now());
//            em.persist(voc2);
//
//        }

        public void dbInit1() {
            Order order1 = createOrder("123-123",2L);
            em.persist(order1);
            Order order2 = createOrder("321-321", 1L);
            em.persist(order2);

            Voc voc1 = createVoc(order1);
            em.persist(voc1);
//            Voc voc2 = createVoc("매니저", "오배송", 10000L, 7000L, 2000L, 8000L);
//            em.persist(voc2);

            Compensation compensation1 = Compensation.createCompensation(voc1, order1);
            em.persist(compensation1);
//            Compensation compensation2 = Compensation.createCompensation(voc2, order2);
//            em.persist(compensation2);

        }

        private Order createOrder(String orderNum, Long boxCount) {
            Order order = new Order();
            order.setOrderNum(orderNum);
            order.setBoxCount(boxCount);
            return order;
        }

        private Voc createVoc(Order order) {
            Voc voc1 = new Voc();
            voc1.setOrder(order);
            voc1.setVocResponsibility("고객사");
            voc1.setVocNote("제품불량");
            voc1.setSellerCost(20000L);
            voc1.setManufacturingCost(17000L);
            voc1.setDeliveryCost(12000L);
            voc1.setCompensateExpense(19000L);
            voc1.setRegDate(LocalDateTime.now());
            return voc1;
        }


    }

}


