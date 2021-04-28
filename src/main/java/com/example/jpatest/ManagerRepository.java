package com.example.jpatest;

import com.example.jpatest.domain.Manager;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ManagerRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Manager manager) {
        em.persist(manager);
        return manager.getId();
    }

    public Manager find(Long id) {
        return em.find(Manager.class, id);
    }
}
