package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class DeliveryPersonEvaluation {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "deliveryPerson_id", nullable = false)
    private DeliveryPerson deliveryPerson;

    private BigDecimal rating;
}
