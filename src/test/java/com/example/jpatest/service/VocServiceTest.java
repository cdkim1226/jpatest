package com.example.jpatest.service;

import com.example.jpatest.domain.Voc;
import com.example.jpatest.repository.VocRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class VocServiceTest {

    @Autowired VocService vocService;
    @Autowired VocRepository vocRepository;

    @Test
    @Rollback(value = false)
    public void insertVoc() throws Exception {

        Voc voc = new Voc();
        voc.setVocResponsibility("매니저");
        voc.setVocNote("오배송");
        voc.setSellerCost(1000L);
        voc.setManufacturingCost(700L);
        voc.setDeliveryCost(200L);
        voc.setCompensateExpense(700L);

        Long insert = vocService.insert(voc);

        Assert.assertEquals(voc, vocRepository.findOne(insert));
    }

}