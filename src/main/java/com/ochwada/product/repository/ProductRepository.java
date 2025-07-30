package com.ochwada.product.repository;


import com.ochwada.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * *******************************************************
 * Package: com.ochwada.product.repository
 * File: ProductRepository.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:37 AM
 * Description: Repository interface for managing {@link Product} entities.
 * Objective:
 * *******************************************************
 */


public interface ProductRepository extends JpaRepository<Product, Long> {

    /** --------------------------------------------------------------------------
     * - Extends {@link JpaRepository} to provide basic CRUD operations, pagination,
     * and sorting functionality for the {@code Product} entity.
     * - Includes a custom finder method to search products by name.
     -------------------------------------------------------------------------------*/

    /**
     * Finds a product by its name.
     *
     * @param name the name of the product to search for
     * @return an {@link Optional} containing the product if found, or empty if not
     */
    Optional<Product> findByName(String name);
}
