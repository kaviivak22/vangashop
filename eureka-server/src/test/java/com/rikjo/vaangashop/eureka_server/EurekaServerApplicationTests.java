package com.rikjo.vaangashop.eureka_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "eureka.client.enabled=false"
})
class EurekaServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
