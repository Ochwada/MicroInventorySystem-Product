package com.ochwada.product.mapper;


import com.ochwada.product.dto.ProductDto;
import com.ochwada.product.model.Product;

/**
 * *******************************************************
 * Package: com.ochwada.product.mapper
 * File: ProductMapper.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:43 AM
 * Description: Utility class for converting between {@link Product} entity and {@link ProductDto}.
 * - This class helps separate concerns between persistence and presentation layers.
 * *******************************************************
 */


public class ProductMapper {

    /**
     * Converts a {@link Product} entity to a {@link ProductDto}, attaching the specified quantity.
     *
     * @param product  the product entity to convert
     * @param quantity the quantity of the product in stock to include in the DTO
     * @return a new {@code ProductDto} containing product details and stock quantity
     */
    public static ProductDto toDTO(Product product, int quantity) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                quantity
        );
    }
}

