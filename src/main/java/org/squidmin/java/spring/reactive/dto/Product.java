package org.squidmin.java.spring.reactive.dto;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@Slf4j
public class Product {

    private Long id;
    private String name;

}
