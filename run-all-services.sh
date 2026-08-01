#!/bin/bash

cd eureka-server/
./mvnw spring-boot:run &

echo "Waiting for Eureka..."

until curl -s http://localhost:8761 > /dev/null; do
    sleep 2
done

echo "Eureka is up."

cd ../api-gateway/
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=8080" &
sleep 2

echo "API Gateway is up."

cd ../product-service/
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9090" &
sleep 2

./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9091" &
sleep 2
cd ../inventory-service/
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9190" &
sleep 2

./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9191" &
sleep 2

./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9192" &
sleep 2

./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9193" &
sleep 2
cd ../order-service/
./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9290" &
sleep 2

./mvnw spring-boot:run -Dspring-boot.run.arguments="--server.port=9291" &
sleep 2