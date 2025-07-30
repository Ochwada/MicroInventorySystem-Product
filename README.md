# 🛒 MicroInventorySystem-Product

**Microservice 1: Product Service**

This is the **Product Service**, a core component in a microservices-based architecture designed to manage product-related data. It handles product creation, retrieval, and provides real-time stock availability by communicating with the external Inventory Service.

---

## 📦 Features

- Store and retrieve product details: ID, name, description, price
- Communicate with `Inventory Service` to check stock quantity
- RESTful API design with Spring Boot
- Clean architecture using DTOs and mappers
- Configurable service URL via application properties

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- RestTemplate
- H2 / PostgreSQL (configurable)
- Maven

 

## 📁 Project Structure
```yaml
micro-inventory-system/
└── product-service/                         # 🧩 Microservice 1: Product Service
    ├── .mvn/
    ├── src/
    │   └── main/
    │       ├── java/
    │       │   └── com.ochwada.product/
    │       │       ├── config/             # Spring configuration (e.g., RestTemplate bean)
    │       │       │   └── AppConfig.java
    │       │       ├── controller/         # REST controller layer
    │       │       │   └── ProductController.java
    │       │       ├── dto/                # Data Transfer Objects
    │       │       │   └── ProductDto.java
    │       │       ├── mapper/             # Mapping logic between entities and DTOs
    │       │       │   └── ProductMapper.java
    │       │       ├── model/              # JPA entity classes
    │       │       │   └── Product.java
    │       │       ├── repository/         # Spring Data JPA repositories
    │       │       │   └── ProductRepository.java
    │       │       └── service/            # Business logic and external service communication
    │       │           ├── InventoryClient.java
    │       │           ├── ProductService.java
    │       │           └── ProductServiceApplication.java
    │       └── resources/
    │           ├── application.properties  # Microservice-specific config (port, inventory URL)
    ├── .gitignore
    ├── pom.xml                             # Maven build file for this microservice
    ├── README.md                           # Service-level documentation
    ├── docker-compose.yml                  # (Optional) Docker setup for running the system
    └── product-service.iml

```
#### 🧩 Highlights:
- This structure clearly defines this as a Spring Boot microservice. 
- Organized by layer: config, controller, dto, mapper, model, repository, service. 
- Can be scaled or integrated with other services (e.g., inventory-service, order-service).

## 📡 API Endpoints

| Method | Endpoint                    | Description         |
|--------|-----------------------------|---------------------|
| GET    | `/api/products`             | Get all products    |
| GET    | `/api/products/{id}`        | Get product by ID   |
| GET    | `/api/products/name/{name}` | Get product by name |
| POST   | `/api/products`             | Add a new product   |

Example response:

```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99,
  "description": "High-performance laptop",
  "quantity": 24
}

