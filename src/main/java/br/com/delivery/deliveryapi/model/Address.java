package br.com.delivery.deliveryapi.model;

import br.com.delivery.deliveryapi.enums.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private Users user;
}
