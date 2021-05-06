package com.example.jpatest.repository.compensation.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompensationSimpleQueryRepository {

    private final EntityManager em;

    public List<SimpleCompensationQueryDto> findCompensationDtos() {
        return em.createQuery(
                "select new com.example.jpatest.repository.compensation.simplequery.SimpleCompensationQueryDto(c.id, o.orderNum, o.boxCount, c.processStatus, v.vocResponsibility, v.vocNote,"+
                        " v.sellerCost, v.manufacturingCost, v.deliveryCost, v.compensateExpense, c.regDate)" +
                        " from Compensation c" +
                        " join c.voc v" +
                        " join c.order o", SimpleCompensationQueryDto.class)
                .getResultList();

    }
}
