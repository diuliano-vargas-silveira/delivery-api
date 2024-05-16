package br.com.delivery.deliveryapi.model;

import br.com.delivery.deliveryapi.enums.OrderStatus;
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
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientPersonId", nullable = false)
    private ClientPerson clientPerson;

    @ManyToOne
    @JoinColumn(name = "deliveryPerson_id", nullable = false)
    private DeliveryPerson deliveryPerson;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<ProductOrder> productOrders;
}
