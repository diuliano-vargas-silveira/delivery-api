package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DeliveryPerson extends User {
  @CPF private String cpf;
  private List<Float> rating;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
  private List<Order> orders;
}
