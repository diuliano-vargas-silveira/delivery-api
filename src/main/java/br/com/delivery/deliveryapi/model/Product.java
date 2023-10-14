package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private BigDecimal price;

    @CollectionTable
    private List<String> categories;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
