package br.com.delivery.deliveryapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DeliveryPerson extends Users {

    @CPF
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<DeliveryPersonEvaluation> rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    private List<Order> orders;
}
