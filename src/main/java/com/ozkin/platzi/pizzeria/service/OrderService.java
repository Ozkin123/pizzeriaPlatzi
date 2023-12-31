package com.ozkin.platzi.pizzeria.service;

import com.ozkin.platzi.pizzeria.persistence.entity.OrderEntity;
import com.ozkin.platzi.pizzeria.persistence.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    public List<OrderEntity>getAll(){
        return this.orderRepository.findAll();
    }

}
