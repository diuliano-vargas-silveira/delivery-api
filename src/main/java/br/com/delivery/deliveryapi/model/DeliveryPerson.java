package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;
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
public class DeliveryPerson extends Users {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<DeliveryPersonEvaluation> rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<Order> orders;
}
