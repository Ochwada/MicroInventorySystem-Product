package com.ochwada.product.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.product.service
 * File: InventoryClient.java
 * Author: Ochwada
 * Date: Wednesday, 30.Jul.2025, 9:48 AM
 * Description: HTTP client to communicate with inventory-service
 * *******************************************************
 */

@Component
@RequiredArgsConstructor
public class InventoryClient {
    /**
     * The HTTP client used to send requests to external services.
     */
    private  final RestTemplate restTemplate;

    /**
     * The base URL of the inventory service.
     * <p>Injected from the application configuration using the property {@code inventory.service.port}.</p>
     */
    @Value("${inventory.service.port}")
    private String inventoryServiceUrl;

    /**
     * Represents a request to check or update inventory for a specific product and quantity.
     *
     * @param productId the ID of the product
     * @param quantity the quantity of the product involved in the inventory operation
     */
    public record InventoryRequest(Long productId, int quantity){ }


    /**
     * Retrieves the available stock quantity for the given product by making an HTTP GET request
     * to the inventory service.
     *
     * @param productId the ID of the product whose stock quantity is to be fetched
     * @return the stock quantity if available; returns 0 if the inventory service returns {@code null}
     */
    public  int getStockQuantity(Long productId){
        Integer quantity = restTemplate.getForObject(
                inventoryServiceUrl+"/"+productId,
                Integer.class // the returned results i.e. the type Integer
        );
        return quantity != null ? quantity : 0;
    }

    /**
     * Sends a POST request to the inventory service to create an inventory record for the specified product with the
     * given quantity.
     * *
     * This method is typically called after a new product is created, ensuring that its initial stock is registered in
     * the inventory system.
     *
     * @param productId the ID of the product to create inventory for
     * @param quantity  the initial stock quantity to be set
     */
    public  void createInventory(Long productId, int quantity){
        restTemplate.postForObject(
                inventoryServiceUrl,
                new InventoryRequest(productId, quantity),
                Void.class // the returned results i.e. the type Void
        );
    }
}
