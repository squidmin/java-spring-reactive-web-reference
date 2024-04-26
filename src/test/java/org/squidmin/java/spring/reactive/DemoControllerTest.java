package org.squidmin.java.spring.reactive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.squidmin.java.spring.reactive.controller.DemoController;

@WebFluxTest(DemoController.class)
public class DemoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSayHello() {
        webTestClient
            .get().uri("/hello")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("Hello, Spring Reactive");
    }

}
