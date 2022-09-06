package com.example.orderservice.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author TuanNA
 * @Date 05/06/2022 10:47 PM
 * @Version 1.0
 */
@Data
public class OrderLineItemDTO {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
