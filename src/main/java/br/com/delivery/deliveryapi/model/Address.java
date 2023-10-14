package br.com.delivery.deliveryapi.model;

import br.com.delivery.deliveryapi.enums.AddressType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String streetAddress;
    private String area;
    private String complement;
    private String cep;
    private String city;
    private String state;

    @Enumerated(EnumType.STRING)
    private AddressType adressType;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
