package com.vedrunasevilla.tienda.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunasevilla.tienda.persistance.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    // Spring Data lo lee como: líneas cuyo order.id = orderId
    List<OrderItem> findByOrderId(Long orderId);
}
