package com.ozkin.platzi.pizzeria.persistence.repository;

import com.ozkin.platzi.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

    List<PizzaEntity> findByAllAvailableTrueOrderByPrice();

    PizzaEntity findByAllByAvailableTrueAndNameIgnoreCase(String name);

}
