package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DeliveryPerson extends User {
    @CPF
    private String cpf;

    private List<BigDecimal> rating = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<Order> orders = new ArrayList<>();
}
