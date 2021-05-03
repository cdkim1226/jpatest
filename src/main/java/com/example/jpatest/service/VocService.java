package com.example.jpatest.service;

import com.example.jpatest.domain.Voc;
import com.example.jpatest.repository.VocRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VocService {

    private final VocRepository vocRepository;

    // @RequiredArgsConstructor 가 아래 내용을 추가 해줌
//    @Autowired
//    public VocService(VocRepository vocRepository) {
//        this.vocRepository = vocRepository;
//    }

    public Long insert(Voc voc) {
        vocRepository.save(voc);
        return voc.getId();
    }

    public List<Voc> findVocList() {
        return vocRepository.findAll();
    }

    public Voc findOne(Long vocSeq) {
        return vocRepository.findOne(vocSeq);
    }

    @Transactional
    public void update(Long id, String vocResponsibility) {
        Voc voc = vocRepository.findOne(id);
        voc.setVocResponsibility(vocResponsibility);
    }
}
