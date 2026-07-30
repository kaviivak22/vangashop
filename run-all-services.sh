#!/bin/bash

cd eureka-server/
./mvnw spring-boot:run &

echo "Waiting for Eureka..."

until curl -s http://localhost:8761 > /dev/null; do
    sleep 2
done

echo "Eureka is up."

cd ../product-service/
./mvnw spring-boot:run &

cd ../inventory-service/
./mvnw spring-boot:run &

cd ../order-service/
./mvnw spring-boot:run 