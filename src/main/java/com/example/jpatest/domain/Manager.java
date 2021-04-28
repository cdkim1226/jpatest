package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Manager {

    @Id @GeneratedValue
    @Column(name = "manager_seq")
    private Long id;

    @Column(name = "mName")
    private String name;

}
