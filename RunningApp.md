## Start the Application

You can launch your API Gateway using any of these three common methods:

### Method 1: IDE
* Open your project in IntelliJ IDEA or Eclipse.
* Locate `ApiGatewayApplication.java`.
* Right-click the file and select **Run**.

### Method 2: Maven CLI
Open your terminal in the project root directory and run:
```bash
mvn spring-boot:run
```

### Method 3: Compiled JAR
Build the executable package and run the file directly:
```bash
mvn clean package
java -jar target/api-gateway-0.0.1-SNAPSHOT.jar
```

---

## Confirm It Started Successfully

Open your terminal output and verify that it initializes on port 8080 using Netty:
```text
Tomcat started on port(s): 8761 (Eureka Server)...
Netty started on port 8080 (API Gateway)...
DiscoveryClient_API-GATEWAY registering service with eureka...
```
