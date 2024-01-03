package com.ozkin.platzi.pizzeria.persistence.repository;

import com.ozkin.platzi.pizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity,Integer> {

    List<OrderEntity> findAllByDateAfter (LocalDateTime dateTime);

    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
