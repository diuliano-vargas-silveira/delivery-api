package br.com.delivery.deliveryapi.repositories;

import br.com.delivery.deliveryapi.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> getByLogin(String login);
}
