package com.example.jpatest.repository;

import com.example.jpatest.domain.Compensation;
import com.example.jpatest.domain.Voc;
import com.example.jpatest.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CompensationRepository {

    private final EntityManager em;

    public void save(Compensation compensation) {
        em.persist(compensation);
    }

    public Compensation findOne(Long id) {
        return em.find(Compensation.class, id);
    }

    public List<Compensation> findAll() {
        return em.createQuery("select c from Compensation c", Compensation.class)
                .getResultList();
    }

    public List<Compensation> findAllWithVocOrder() {
        return em.createQuery(
                "select c from Compensation c" +
                        " join fetch c.voc v" +
                        " join fetch c.order o", Compensation.class
        ).getResultList();
    }
}

