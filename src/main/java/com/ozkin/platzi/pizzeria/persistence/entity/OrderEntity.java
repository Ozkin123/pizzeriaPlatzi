package com.ozkin.platzi.pizzeria.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pizza_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_costumer", nullable = false, length = 15)
    private String idCostumer;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private Double total;

    @Column(nullable = false,columnDefinition = "CHAR(1)")
    private String method;

    @Column(name = "additional_notes",length = 200)
    private String additionalNotes;




}
