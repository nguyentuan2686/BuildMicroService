package com.example.orderservice.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @Author TuanNA
 * @Date 06/06/2022 11:31 PM
 * @Version 1.0
 */
@Data
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
