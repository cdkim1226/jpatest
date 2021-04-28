package com.example.jpatest.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_seq")
    private Long id;

    @Column(name = "customerName")
    private String name;
}
