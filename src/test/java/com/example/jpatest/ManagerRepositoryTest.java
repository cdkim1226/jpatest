package com.example.jpatest;

import com.example.jpatest.domain.Manager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerRepositoryTest {

    @Autowired ManagerRepository managerRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testManager() throws Exception {
        //given
        Manager manager = new Manager();
        manager.setName("managerA");

        //when
        Long savedId = managerRepository.save(manager);
        Manager findManager = managerRepository.find(savedId);

        //then
        Assertions.assertThat(findManager.getId()).isEqualTo(manager.getId());
        Assertions.assertThat(findManager.getName()).isEqualTo(manager.getName());
        Assertions.assertThat(findManager).isEqualTo(manager);
    }
}