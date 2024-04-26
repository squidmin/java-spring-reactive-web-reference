package org.squidmin.java.spring.reactive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.squidmin.java.spring.reactive.controller.RecommendationController;
import org.squidmin.java.spring.reactive.dto.Product;
import org.squidmin.java.spring.reactive.service.RecommendationService;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@WebFluxTest(RecommendationController.class)
public class RecommendationControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        List<Product> products = Arrays.asList(
            new Product(1L, "Product 1"),
            new Product(2L, "Product 2")
        );

        // Simulate the service's response when fetching recommendations
        Mockito.when(recommendationService.getRecommendations(1L))
            .thenReturn(Flux.fromIterable(products));
    }

    @Test
    void getRecommendations_ReturnsCorrectProducts() {
        webTestClient.get().uri("/api/products/1/recommendations")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(Product.class).isEqualTo(Arrays.asList(
                new Product(1L, "Product 1"),
                new Product(2L, "Product 2")
            ));
    }

}
