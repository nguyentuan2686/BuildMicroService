package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderLineItemDTO;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @Author TuanNA
 * @Date 05/06/2022 11:08 PM
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemDTOList().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        order.setOrderLineItemList(orderLineItemList);

        List<String> skuCode = order.getOrderLineItemList().stream().map(OrderLineItem::getSkuCode).toList();

        InventoryResponse[] inventoryResponses = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCode).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class).block();
        boolean allProductInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        if (Boolean.TRUE.equals(allProductInStock)) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock");
        }

    }

    private OrderLineItem mapToDto(OrderLineItemDTO orderLineItemDTO) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDTO.getPrice());
        orderLineItem.setQuantity(orderLineItemDTO.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDTO.getSkuCode());
        return orderLineItem;
    }
}
