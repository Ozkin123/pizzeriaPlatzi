package com.ozkin.platzi.pizzeria.persistence.repository;

import com.ozkin.platzi.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

    PizzaEntity findAllByAvailableTrueAndNameIgnoreCase(String name);

    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainIgnoreCase(String description);

    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainIgnoreCase(String description);

}
