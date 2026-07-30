#!/usr/bin/env bash

services=(
  "eureka-server"
  "api-gateway"
  "product-service"
  "order-service"
  "inventory-service"
  "user-service"
)

for service in "${services[@]}"
do
    echo "Formatting $service..."
    (
        cd "$service" || exit 1
        ./mvnw spotless:apply || exit 1
    )
done

echo "All services formatted successfully!"