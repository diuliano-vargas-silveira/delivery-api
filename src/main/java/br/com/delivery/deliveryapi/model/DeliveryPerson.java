package br.com.delivery.deliveryapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
public class DeliveryPerson extends User {

    @CPF
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<DeliveryPersonEvaluation> rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<Order> orders;
}
