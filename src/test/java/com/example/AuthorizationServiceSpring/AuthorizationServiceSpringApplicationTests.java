package com.example.AuthorizationServiceSpring;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceSpringApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Container
    private final GenericContainer<?> devapp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private final GenericContainer<?> prodapp = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);


    @Test
    void contextLoads() {
        Integer devappPort = devapp.getMappedPort(8080);
        Integer prodappPort = prodapp.getMappedPort(8081);


        ResponseEntity<String> entityFromDevapp = restTemplate.getForEntity(
                "http://localhost:" + devappPort + "/authorize?user=Sabir&password=12345", String.class);

        ResponseEntity<String> entityFromProdapp = restTemplate.getForEntity(
                "http://0.0.0.0:" + prodappPort + "/authorize?user=Ribas&password=54321", String.class);

        Assertions.assertEquals(entityFromDevapp.getBody(), "[\"WRITE\",\"DELETE\"]");
        Assertions.assertEquals(entityFromProdapp.getBody(), "[\"READ\"]");


    }

}


