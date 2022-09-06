package com.example.productservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author TuanNA
 * @Date 22/05/2022 11:26 PM
 * @Version 1.0
 */
@Data
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
