package com.ozkin.platzi.pizzeria.service;

import com.ozkin.platzi.pizzeria.persistence.entity.PizzaEntity;
import com.ozkin.platzi.pizzeria.persistence.repository.PizzaPagSortRepository;
import com.ozkin.platzi.pizzeria.persistence.repository.PizzaRepository;
import com.ozkin.platzi.pizzeria.service.dto.UpdatePizzaPriceDto;
import com.ozkin.platzi.pizzeria.service.exception.EmailApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
    }

    public Page<PizzaEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page,elements);
        return this.pizzaPagSortRepository.findAll(pageRequest);
    }

    public Page<PizzaEntity> getAvailable(int page,int elements, String sortBy, String sortDirection){
        this.pizzaRepository.countByVeganTrue();
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageRequest = PageRequest.of(page,elements, sort);
        return this.pizzaPagSortRepository.findByAvailableTrue(pageRequest);
    }

    public List<PizzaEntity> getWith(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithOut(String ingredient){
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getCheapest(double price){
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByAsc(price);
    }
    public PizzaEntity getByName(String name){
        return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name)
                .orElseThrow(()->new RuntimeException("La pizza no existe"));
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

    @Transactional(noRollbackFor = EmailApiException.class)
    public void updatePrice(UpdatePizzaPriceDto dto){
        this.pizzaRepository.updatePrice(dto);
    }

    private void sendEmail(){
         throw new EmailApiException();
    }

    public boolean exists(int pizzaID){
        return pizzaRepository.existsById(pizzaID);
    }


}
