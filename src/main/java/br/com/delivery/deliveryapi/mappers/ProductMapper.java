package br.com.delivery.deliveryapi.mappers;

import br.com.delivery.deliveryapi.dto.CreateProductRequest;
import br.com.delivery.deliveryapi.model.Product;

import java.util.ArrayList;
import java.util.UUID;

public class ProductMapper {

    public static Product createProductRequestToProduct(CreateProductRequest createProductRequest) {
        return Product
                .builder()
                .id(UUID.randomUUID())
                .name(createProductRequest.name())
                .price(createProductRequest.price())
                .productOrders(new ArrayList<>())
                .restaurant(null)
                .categories(createProductRequest.categories())
                .photo(createProductRequest.photo())
                .build();
    }

}
