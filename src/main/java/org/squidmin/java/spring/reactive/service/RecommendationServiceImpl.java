package org.squidmin.java.spring.reactive.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.squidmin.java.spring.reactive.dto.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final String baseUrl;
    private final WebClient webClient;

    public RecommendationServiceImpl(@Value("${product-recommendations.base-url}") String baseUrl, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public Flux<Product> getRecommendations(Long productId) {
        Mono<List<Product>> purchaseHistoryRecommendation = webClient
            .get()
            .uri("http://" + baseUrl + "/products/{id}/purchaseHistory", productId)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<List<Product>>() {
            });

        Mono<List<Product>> coOccurrenceRecommendation = webClient
            .get()
            .uri("http://" + baseUrl + "/products/{id}/coOccurrence", productId)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<List<Product>>() {
            });

        return Flux.concat(
            purchaseHistoryRecommendation.flatMapMany(Flux::fromIterable),
            coOccurrenceRecommendation.flatMapMany(Flux::fromIterable)
        );
    }

}
