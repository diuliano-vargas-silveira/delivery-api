package br.com.delivery.deliveryapi.controllers;

import br.com.delivery.deliveryapi.dto.CreateProductRequest;
import br.com.delivery.deliveryapi.exceptions.NoTokenPresentException;
import br.com.delivery.deliveryapi.exceptions.UserNotFoundException;
import br.com.delivery.deliveryapi.mappers.ProductMapper;
import br.com.delivery.deliveryapi.services.RestaurantService;
import br.com.delivery.deliveryapi.utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService service;
    private final TokenUtil tokenUtil;

    @PostMapping("/product")
    public void createProduct(@RequestBody CreateProductRequest request, @RequestHeader Map<String, String> headers) throws NoTokenPresentException, UserNotFoundException {
        String restaurantLogin = tokenUtil.getUserByLogin(headers);
        var product = ProductMapper.createProductRequestToProduct(request);

        service.addProduct(product, restaurantLogin);
    }
}
