package com.ochwada.product.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * *******************************************************
 * Package: com.ochwada.product.dto
 * File: ProductDto.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:40 AM
 * Description: DTO for exposing product to clients, including stock quantity
 * - This class is used to transfer product data between different layers of the application without exposing internal
 * entity details or persistence logic.
 * *******************************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    /**
     * The unique identifier for the product.
     * <p>Auto-generated using identity strategy.</p>
     */
    private Long id;

    /**
     * The name of the product.
     */
    private String name;

    /**
     * The price of the product.
     */
    private double price;

    /**
     * A brief description of the product.
     */
    private String description;

    /**
     * The quantity of the product in stock.
     */
    private int quantity;
}
