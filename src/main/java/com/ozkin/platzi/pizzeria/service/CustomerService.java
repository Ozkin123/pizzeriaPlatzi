package com.ozkin.platzi.pizzeria.service;

import com.ozkin.platzi.pizzeria.persistence.entity.CustomerEntity;

import com.ozkin.platzi.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository=customerRepository;
    }


    public CustomerEntity findByPhone (String phone){
       return this.customerRepository.findByPhone(phone);
    }
}