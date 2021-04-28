package com.example.jpatest.repository;

import com.example.jpatest.domain.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class VocRepository {

    private final EntityManager em;

    public void save(Voc voc) {
        em.persist(voc);
    }

    public Voc findOne(Long id) {
        return em.find(Voc.class, id);
    }

    public List<Voc> findAll() {
        return em.createQuery("select v from Voc v", Voc.class)
                .getResultList();
    }


}
