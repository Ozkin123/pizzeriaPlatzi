package com.ozkin.platzi.pizzeria.service;

import com.ozkin.platzi.pizzeria.persistence.entity.PizzaEntity;
import com.ozkin.platzi.pizzeria.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<PizzaEntity> getAll() {
        return this.pizzaRepository.findAll();
    }

    public List<PizzaEntity> getAvailable(){
       return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getWith(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithOut(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainIgnoreCase(ingredient);
    }
    public PizzaEntity getByName(String name){
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }



    public PizzaEntity get(int idPizza){
        return pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza){
        return pizzaRepository.save(pizza);
    }

    public void delete(int idPizza){
        this.pizzaRepository.deleteById(idPizza);
    }

    public boolean exists(int pizzaID){
        return pizzaRepository.existsById(pizzaID);
    }


}
