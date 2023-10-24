package br.com.delivery.deliveryapi.services;

import br.com.delivery.deliveryapi.exceptions.UserNotFoundException;
import br.com.delivery.deliveryapi.model.Product;
import br.com.delivery.deliveryapi.repositories.ProductRepository;
import br.com.delivery.deliveryapi.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repository;
    private final ProductRepository productRepository;

    public void addProduct(Product product, String restaurantLogin) throws UserNotFoundException {
        var optionalRestaurant = repository.getByLogin(restaurantLogin);

        if (optionalRestaurant.isEmpty()) {
            throw new UserNotFoundException();
        }

        var restaurant = optionalRestaurant.get();

        product.setRestaurant(restaurant);
        restaurant.getProducts().add(product);

        repository.save(restaurant);
        productRepository.save(product);
    }
}
