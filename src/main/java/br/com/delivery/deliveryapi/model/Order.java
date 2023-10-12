package br.com.delivery.deliveryapi.model;

import br.com.delivery.deliveryapi.enums.OrderStatus;
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
@Entity(name = "orders")
public class Order {
  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  @ManyToMany
  @JoinTable(
      name = "product_order",
      joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
  private List<Product> products;

  @ManyToOne
  @JoinColumn(name = "restaurant_id", nullable = false)
  private Restaurant restaurant;

  @ManyToOne
  @JoinColumn(name = "delivery_person_id")
  private DeliveryPerson deliveryPerson;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
