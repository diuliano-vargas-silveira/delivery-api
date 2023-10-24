package br.com.delivery.deliveryapi.dto;

import java.math.BigDecimal;
import java.util.List;

public record CreateProductRequest(String name, String photo, BigDecimal price, List<String> categories) {
}
