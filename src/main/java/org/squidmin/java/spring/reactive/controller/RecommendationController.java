package org.squidmin.java.spring.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.squidmin.java.spring.reactive.dto.Product;
import org.squidmin.java.spring.reactive.service.RecommendationService;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{productId}/recommendations")
    public Mono<List<Product>> getRecommendations(@PathVariable Long productId) {
        return recommendationService.getRecommendations(productId)
            .collectList(); // Collect recommendations into a list
    }

}
