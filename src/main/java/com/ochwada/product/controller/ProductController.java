package com.ochwada.product.controller;


import com.ochwada.product.dto.ProductDto;
import com.ochwada.product.model.Product;
import com.ochwada.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * *******************************************************
 * Package: com.ochwada.product.controller
 * File: ProductController.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 10:39 AM
 * Description: REST controller for exposing product-related HTTP endpoints.
 * - By default the {@link com.ochwada.product.config.SecurityConfig} already enforces that every request must be
 * authenticated.
 * Objective: Handle client requests for retrieving and adding products, and delegate the business logic to the
 * {@link ProductService}.
 * *******************************************************
 */

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService service;

    /**
     * Request payload for creating a product along with its stock quantity.
     *
     * @param product  the product to be created
     * @param quantity the initial quantity to set in the inventory
     */
    public record productWithQuantity(Product product, int quantity){ }

    /**
     * Retrieves all products along with their current stock quantities.
     *
     * @return a list of {@link ProductDto} containing product and stock information
     */
    @GetMapping
    public List<ProductDto> getAllProducts(){
        return  service.getAllProducts();
    }

    /**
     * Adds a new product to the system and sets its initial stock quantity.
     *
     * @param request a {@code productWithQuantity} object containing product info and quantity
     * @return the newly added product as a {@link ProductDto}
     */
    @PostMapping
    public  ProductDto addProduct(@RequestBody productWithQuantity request){
        return  service.addProduct(request.product(), request.quantity());
    }


}
