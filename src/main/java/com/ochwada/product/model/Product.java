package com.ochwada.product.model;


import jakarta.persistence.*;
import lombok.*;

/**
 * *******************************************************
 * Package: com.ochwada.product.model
 * File: Product.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:34 AM
 * Description: Entity representing a product in the catalog
 * - This entity is mapped to the {@code products} table in the database
 * *******************************************************
 */

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * The unique identifier for the product.
     * <p>Auto-generated using identity strategy.</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the product.
     */
    private  String name;

    /**
     * The price of the product.
     */
    private  double price;

    /**
     * A brief description of the product.
     */
    private  String description;
}
