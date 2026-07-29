# Spring Boot Microservices E-Commerce Application

Please refer this Repo in case of any doubts : https://github.com/oddy-bassey/Programming-Techie-SpringBoot-Microservices/tree/main

## Project Overview

Build a beginner-friendly **E-Commerce Application** similar to **Amazon** or **Flipkart** using **Spring Boot Microservices Architecture**.

The application should demonstrate the core concepts of microservices, including:

- Service Discovery using Eureka Server
- API Gateway
- Inter-service Communication using OpenFeign
- Independent databases for each microservice
- RESTful APIs
- React.js Frontend
- Layered Architecture

The project should be simple, clean, and suitable for learning and portfolio purposes.

---

# Technology Stack

## Backend

- Java 25 (or Java 21)
- Spring Boot 4.x
- Spring Cloud
- Spring Web
- Spring Data JPA
- Spring Security (Basic Authentication or JWT - Simple)
- Spring Cloud OpenFeign
- Spring Cloud Gateway
- Eureka Server
- Lombok
- Maven
- MySQL
- Swagger / OpenAPI

---

## Frontend

- React.js
- Axios
- React Router
- Bootstrap or Material UI

---

# Project Architecture

```
                    React Frontend
                           │
                           ▼
                    API Gateway (8080)
                           │
         ┌─────────────────┼─────────────────┐
         ▼                 ▼                 ▼
 Product Service      Order Service      User Service
      (8081)             (8082)             (8083)
         │                  │
         │                  │
         └──────Feign───────┘
                │
                ▼
         Product Service

All services register with

         Eureka Server (8761)
```

---

# Microservices

## 1. Product Service

### Responsibilities

- Add Product
- Update Product
- Delete Product
- Get Product By ID
- Get All Products
- Search Product By Name

### Product Entity

| Field | Type |
|--------|------|
| id | Long |
| name | String |
| description | String |
| category | String |
| price | Double |
| stock | Integer |
| imageUrl | String |

### REST APIs

```
GET     /products
GET     /products/{id}
POST    /products
PUT     /products/{id}
DELETE  /products/{id}
GET     /products/search?name=
```

---

## 2. Order Service

### Responsibilities

- Place Order
- View Orders
- View Order Details

### Features

- Communicate with Product Service using OpenFeign
- Fetch Product Information
- Validate Stock
- Calculate Total Price
- Save Order

### Order Entity

| Field | Type |
|--------|------|
| id | Long |
| productId | Long |
| productName | String |
| quantity | Integer |
| totalPrice | Double |
| orderDate | LocalDate |

### REST APIs

```
POST /orders
GET  /orders
GET  /orders/{id}
```

### OpenFeign

Use

```java
@FeignClient(name = "PRODUCT-SERVICE")
```

Do **not** use RestTemplate.

---

## 3. User Service

### Responsibilities

- Register User
- Login
- Get User Details

### User Entity

| Field | Type |
|--------|------|
| id | Long |
| name | String |
| email | String |
| password | String |

### REST APIs

```
POST /users/register
POST /users/login
GET  /users/{id}
```

---

# Eureka Server

Configure a Eureka Discovery Server.

All microservices must automatically register with Eureka.

Services:

- Eureka Server
- API Gateway
- Product Service
- Order Service
- User Service

---

# API Gateway

Use **Spring Cloud Gateway**.

Configure routing.

| Route | Service |
|--------|----------|
| /products/** | Product Service |
| /orders/** | Order Service |
| /users/** | User Service |

Frontend must communicate only through the API Gateway.

Example:

```
http://localhost:8080/products
```

---

# OpenFeign Communication

The Order Service communicates with the Product Service using OpenFeign.

Example Flow:

```
Order Service
      │
      ▼
Feign Client
      │
      ▼
Product Service
```

---

# Database Design

Each microservice should have its own MySQL database.

## Databases

```
product_db

order_db

user_db
```

Each service should contain:

- Entity
- DTO
- Repository
- Service
- Controller
- Exception Handling
- FrontEnd: React.js, Redux, ReduxThunk, Javascript (ES6+), HTML5, CSS3,JSX,React Hooks
- BackEnd:Java,SpringBoot,RESTful WebServices, Microservices
-  Testing: Jest, Bruno,Unit Testing
- API & Integration :REST APIs, Axios
- Tools & Platforms : GitHub,Webpack,Docker,Jira,Confluence,VSCode NVDA,CCA(Color contrast Analyzer)
---

# Project Structure

```
vangashop/
│
├── pom.xml                               # Master Aggregator and Dependency Management
│
├── eureka-server/                        # Port 8761: Service Discovery
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ecommerce/eurekaserver/EurekaServerApplication.java
│       └── resources/application.yml
│
├── api-gateway/                          # Port 8080: Routing & Global CORS Filter
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ecommerce/apigateway/ApiGatewayApplication.java
│       └── resources/application.yml
│
├── product-service/                      # Port 8081: Independent Product Domain
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ecommerce/
│       │   ├── productservice/
│       │   │   ├── ProductServiceApplication.java
│       │   │   ├── controller/ProductController.java
│       │   │   ├── dto/ProductDTO.java
│       │   │   ├── entity/Product.java
│       │   │   ├── repository/ProductRepository.java
│       │   │   └── service/ProductService.java
│       │   └── shared/exception/GlobalExceptionHandler.java
│       └── resources/
│           ├── application.yml
│           └── data.sql                  # Automated Sample Inventory Seeds
│
├── order-service/                        # Port 8082: Transactions & Stock Consumption
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ecommerce/
│       │   ├── orderservice/
│       │   │   ├── OrderServiceApplication.java
│       │   │   ├── client/OrderClient.java (OpenFeign Interface)
│       │   │   ├── controller/OrderController.java
│       │   │   ├── dto/OrderDTO.java & ProductDTO.java
│       │   │   ├── entity/Order.java
│       │   │   ├── repository/OrderRepository.java
│       │   │   └── service/OrderService.java
│       │   └── shared/exception/GlobalExceptionHandler.java
│       └── resources/application.yml
│
├── user-service/                         # Port 8083: Accounts Management
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/ecommerce/
│       │   ├── userservice/
│       │   │   ├── UserServiceApplication.java
│       │   │   ├── controller/UserController.java
│       │   │   ├── dto/UserDTO.java
│       │   │   ├── entity/User.java
│       │   │   ├── repository/UserRepository.java
│       │   │   └── service/UserService.java
│       │   └── shared/exception/GlobalExceptionHandler.java
│       └── resources/application.yml
│
└── react-frontend/                       # Port 3000: SPA Web Client Application
    ├── package.json
    ├── public/index.html
    └── src/
        ├── App.js                        # Layout Controller & Client Routing
        ├── index.js
        ├── components/
        │   └── Navbar.js                 # Unified Search Engine Interface
        └── pages/
            ├── Home.js                   # Dynamic Inventory Catalog
            ├── ProductDetails.js         # Quantity Selector & Purchase Pipeline
            ├── Orders.js                 # Transaction History Log
            ├── Login.js                  # Security Identity Handshake
            └── Register.js               # Profiling Registration Form

```

---

# React Frontend

Develop a simple UI inspired by Amazon or Flipkart.

## Pages

- Home
- Product Details
- Orders
- Login
- Register

---

## Components

- Navbar
- Footer
- Product Card
- Product List
- Product Details
- Order Form
- Login
- Register

---

# UI Layout

## Navbar

- Logo
- Search
- Home
- Orders
- Login

---

## Product Card

Display

- Product Image
- Product Name
- Price
- Buy Button

---

# Ports

| Service | Port |
|----------|------|
| Eureka Server | 8761 |
| API Gateway | 8080 |
| Product Service | 8081 |
| Order Service | 8082 |
| User Service | 8083 |
| React Frontend | 3000 |

---

# Validation

Use Jakarta Validation annotations.

Examples:

- @NotNull
- @NotBlank
- @Email
- @Positive

---

# Logging

Use SLF4J logging.

Log:

- Requests
- Responses
- Exceptions
- Service Communication

---

# API Documentation

Generate Swagger/OpenAPI documentation for every microservice.

---

# Sample Data

Populate sample products using:

```
data.sql
```

---

# Development Guidelines

- Use Layered Architecture.
- Use DTOs instead of exposing entities directly.
- Use Lombok annotations.
- Implement Global Exception Handling.
- Keep code clean and modular.
- Follow REST API best practices.

---

# Deliverables

The generated project should include:

- Complete folder structure
- Maven `pom.xml` for every module
- `application.yml` configuration for every service
- Complete source code
- Database configuration
- OpenFeign configuration
- Eureka configuration
- API Gateway configuration
- Swagger configuration
- Sample SQL scripts
- React frontend
- Step-by-step explanation of each module

---

# Generation Order

Generate the project in the following sequence:

1. Eureka Server
2. API Gateway
3. Product Service
4. Order Service
5. User Service
6. React Frontend
7. Integration Testing
8. Project Execution Guide

---

# Expected Outcome

The final project should:

- Run successfully without compilation errors.
- Be importable into IntelliJ IDEA or Eclipse.
- Demonstrate microservices architecture using Spring Boot.
- Showcase service discovery using Eureka.
- Use OpenFeign for inter-service communication.
- Route requests through Spring Cloud Gateway.
- Provide a simple React-based e-commerce UI.
- Be suitable as a learning project and portfolio showcase.
