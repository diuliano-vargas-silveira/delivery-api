package br.com.delivery.deliveryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String photo;
    private BigDecimal price;

    @CollectionTable
    private List<String> categories;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductOrder> productOrders;
}
