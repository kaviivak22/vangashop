## 📖 API Documentation & Swagger UI

You can view and test the interactive API documentation using Swagger UI. Make sure the microservices are running before accessing the links.

### Direct Service Links (Internal Ports)
*   **Product Service:** [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
*   **Raw OpenAPI Specifications:** [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)

### API Gateway Proxied Links (Port 8080)
If you are running the system through the API Gateway, use these endpoints:
*   **Product Service UI:** [http://localhost:8080/product-service/swagger-ui/index.html](http://localhost:8080/product-service/swagger-ui/index.html)
*   **Product Service Specs:** [http://localhost:8080/product-service/v3/api-docs](http://localhost:8080/product-service/v3/api-docs)

### 🚀 How to Test Endpoints
1. Open any of the **Swagger UI** links above in your browser.
2. Expand the desired controller block (e.g., `product-controller`).
3. Click the **"Try it out"** button.
4. Provide any required path variables or JSON request body data.
5. Click **"Execute"** to view real-time database responses and status codes.
