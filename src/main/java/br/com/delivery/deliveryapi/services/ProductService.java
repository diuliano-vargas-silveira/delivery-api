package br.com.delivery.deliveryapi.services;

import br.com.delivery.deliveryapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Map<String, Object>> GetMostSoldLastWeek() {
        var products = productRepository.getMostSoldLastWeek();

        return products;
    }
}
