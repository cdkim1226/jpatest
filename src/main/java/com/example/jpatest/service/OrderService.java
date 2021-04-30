package com.example.jpatest.service;

import com.example.jpatest.domain.Order;
import com.example.jpatest.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order findOne(Long orderSeq) {
        return orderRepository.findOne(orderSeq);
    }

    public List<Order> findOrderList() {
        return orderRepository.findAll();

    }
}
