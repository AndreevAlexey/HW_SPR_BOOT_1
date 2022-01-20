package com.example.hw_spr_boot_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    public static GenericContainer<?> prodapp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

    public static GenericContainer<?> devapp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    @BeforeAll
    public static void setUp() {
        prodapp.start();
        devapp.start();
    }

    @Test
    void test_prod_profile() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodapp.getMappedPort(8081) + "/profile", String.class);
        String result = forEntity.getBody();
        String expected = "Current profile is production";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_dev_profile() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080) + "/profile", String.class);
        String result = forEntity.getBody();
        String expected = "Current profile is dev";
        Assertions.assertEquals(expected, result);
    }

}
