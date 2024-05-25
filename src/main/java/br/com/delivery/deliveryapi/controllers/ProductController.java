package br.com.delivery.deliveryapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import br.com.delivery.deliveryapi.services.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/most-sold")
    public List<Map<String, Object>> GetMostSold() {
        return productService.GetMostSoldLastWeek();
    }
}
