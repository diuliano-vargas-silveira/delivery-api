package br.com.delivery.deliveryapi.repositories;

import br.com.delivery.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {
}
