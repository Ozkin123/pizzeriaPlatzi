package com.ozkin.platzi.pizzeria.webcontroller;


import com.ozkin.platzi.pizzeria.persistence.entity.OrderEntity;
import com.ozkin.platzi.pizzeria.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>>getAll(){
        return ResponseEntity.ok(this.orderService.getAll());
    }

}
