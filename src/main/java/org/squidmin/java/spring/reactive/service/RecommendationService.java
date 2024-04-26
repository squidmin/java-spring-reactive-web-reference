package org.squidmin.java.spring.reactive.service;

import org.squidmin.java.spring.reactive.dto.Product;
import reactor.core.publisher.Flux;

public interface RecommendationService {

    Flux<Product> getRecommendations(Long productId);

}
