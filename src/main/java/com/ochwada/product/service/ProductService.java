package com.ochwada.product.service;


import com.ochwada.product.dto.ProductDto;
import com.ochwada.product.mapper.ProductMapper;
import com.ochwada.product.model.Product;
import com.ochwada.product.repository.ProductRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


/**
 * *******************************************************
 * Package: com.ochwada.product.service
 * File: ProductService.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:48 AM
 * Description: Service layer that encapsulates the business logic for managing products.
 * Objective: Retrieve product data from the database and enrich it with  real-time stock quantity information fetched
 * from the inventory service.
 * <p>
 * This class uses the {@link ProductRepository} to interact with the product database and {@link InventoryClient} to
 * obtain current stock levels.
 * *******************************************************
 */

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final InventoryClient client;

    /**
     * Retrieves all products from the database and maps them to DTOs enriched with
     * real-time stock quantity from the inventory service.
     *
     * @return a list of {@link ProductDto} containing product details and current stock levels
     */
    public List<ProductDto> getAllProducts() {
        List<Product> products = repository.findAll();

        List<ProductDto> allProducts = products.stream()
                .map(
                        product -> ProductMapper.toDTO(
                                product,
                                client.getStockQuantity(product.getId())
                        )
                ).collect(Collectors.toList());
        return allProducts;
    }

    /**
     * Adds a new product to the system and initializes its stock in the inventory service.
     *
     * <p>This method first checks if a product with the same name already exists. If it does,
     * a {@link RuntimeException} is thrown. Otherwise, the product is saved in the database and
     * the stock quantity is initialized in the inventory service.</p>
     *
     * @param product  the product entity to be added
     * @param quantity the initial stock quantity to be registered in the inventory
     * @return the saved product as a {@link ProductDto}, including stock quantity
     * @throws RuntimeException if a product with the same name already exists
     */
    public ProductDto addProduct(Product product, int quantity) {
        Optional<Product> existing = repository.findByName(product.getName());

        if (existing.isPresent()) {
            throw new RuntimeException("Product already exists");
        }

        Product savedProduct = repository.save(product);

        client.createInventory(savedProduct.getId(), quantity);

        return  ProductMapper.toDTO(savedProduct, quantity);
    }
}
