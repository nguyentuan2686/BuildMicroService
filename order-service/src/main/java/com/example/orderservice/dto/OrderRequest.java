package com.example.orderservice.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author TuanNA
 * @Date 05/06/2022 10:46 PM
 * @Version 1.0
 */
@Data
public class OrderRequest {
    private List<OrderLineItemDTO> orderLineItemDTOList;
}
