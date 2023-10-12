package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

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

  @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
  private List<Address> addresses;

  private String profilePhoto;

  private String phoneNumber;

  private List<Float> evaluations;
}
