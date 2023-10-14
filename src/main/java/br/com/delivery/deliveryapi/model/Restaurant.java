package br.com.delivery.deliveryapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Restaurant extends User {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<Address> addresses;

    private String profilePhoto;

    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "restaurant")
    private List<RestaurantEvaluation> evaluations;
}
