package com.example.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @Author TuanNA
 * @Date 22/05/2022 10:56 PM
 * @Version 1.0
 */
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
