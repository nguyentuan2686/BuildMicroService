package com.example.orderservice.repository;

import com.example.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author TuanNA
 * @Date 05/06/2022 11:15 PM
 * @Version 1.0
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
