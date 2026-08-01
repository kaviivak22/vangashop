#!/usr/bin/env bash

echo "Stopping Spring Boot microservices..."

pkill -f InventoryServiceApplication
pkill -f OrderServiceApplication
pkill -f ProductServiceApplication
pkill -f ApiGatewayApplication
pkill -f EurekaServerApplication

echo "All microservices stopped."
