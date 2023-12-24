package com.ozkin.platzi.pizzeria.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
public class CostumerEntity {

    @Id
    @Column(name = "id_costumer", nullable = false, length = 15)
    private String costumerID;

    @Column(nullable = false , length = 60)
    private String name;

    @Column(length = 100)
    private String address;

    @Column(nullable = false, length = 50,unique = true)
    private String email;
    @Column(name = "phone_number", length = 20)
    private Integer phoneNumber;
}
