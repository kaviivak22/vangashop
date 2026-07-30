#!/usr/bin/env bash

echo "**** Building all services Using Maven ****"
echo " EUREKA-SERVER build ..."

cd eureka-server/
./mvnw clean install -DskipTests || exit 1 

echo " PRODUCT-SERVICE build ..."
cd ../product-service/
./mvnw clean install  -DskipTests || exit 1 

echo " INVENTORY-SERVICE build ..."
cd ../inventory-service/
./mvnw clean install -DskipTests || exit 1

echo " ORDER-SERVICE build ..."
cd ../order-service/
./mvnw clean install -DskipTests || exit 1


echo "**** All services built successfully ****"
