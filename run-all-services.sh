#!/bin/bash

cd eureka-server/
./mvnw spring-boot:run &

cd ../product-service/
./mvnw spring-boot:run &

cd ../inventory-service/
./mvnw spring-boot:run &

cd ../order-service/
./mvnw spring-boot:run 