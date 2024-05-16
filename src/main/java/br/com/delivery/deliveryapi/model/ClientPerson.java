package br.com.delivery.deliveryapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name = "client_person")
public class ClientPerson extends Users {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientPerson")
    private List<Order> orders;
}
