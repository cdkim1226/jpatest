package com.example.jpatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Manager {

    @Id @GeneratedValue
    private Long managerSeq;
    private String mName;
}
