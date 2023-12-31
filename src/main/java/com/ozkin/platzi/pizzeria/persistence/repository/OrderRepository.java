package com.ozkin.platzi.pizzeria.persistence.repository;

import com.ozkin.platzi.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity,Integer> {
}
