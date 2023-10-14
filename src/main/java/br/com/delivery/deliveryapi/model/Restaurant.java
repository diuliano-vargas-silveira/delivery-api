package br.com.delivery.deliveryapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private List<RestaurantEvaluation> evaluations;
}
