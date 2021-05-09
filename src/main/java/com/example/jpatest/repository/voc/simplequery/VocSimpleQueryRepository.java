package com.example.jpatest.repository.voc.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VocSimpleQueryRepository {

    private final EntityManager em;

    public List<SimpleVocQueryDto> findVocDtos() {
        return em.createQuery(
                "select new com.example.jpatest.repository.voc.simplequery.SimpleVocQueryDto(v.id, o.orderNum, v.vocResponsibility, v.vocNote,"+
                        " v.sellerCost, v.manufacturingCost, v.deliveryCost, v.compensateExpense, v.regDate)" +
                        " from Voc v"+
                        " join v.order o", SimpleVocQueryDto.class)
                .getResultList();

    }
}
