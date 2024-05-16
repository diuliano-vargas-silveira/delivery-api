package br.com.delivery.deliveryapi.repositories;

import br.com.delivery.deliveryapi.model.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
}
