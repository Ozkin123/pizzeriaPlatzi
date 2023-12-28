package com.ozkin.platzi.pizzeria.persistence.repository;

import com.ozkin.platzi.pizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity,Integer> {


}
