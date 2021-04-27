package com.example.jpatest;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ManagerRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Manager manager) {
        em.persist(manager);
        return manager.getManagerSeq();
    }

    public Manager find(Long managerSeq) {
        return em.find(Manager.class, managerSeq);
    }
}
