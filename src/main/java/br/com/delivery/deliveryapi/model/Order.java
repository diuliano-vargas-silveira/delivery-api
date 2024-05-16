package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id")
    private OrderStatus orderStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<ProductOrder> productOrders;

    private LocalDateTime CreatedAt = LocalDateTime.now();
}
