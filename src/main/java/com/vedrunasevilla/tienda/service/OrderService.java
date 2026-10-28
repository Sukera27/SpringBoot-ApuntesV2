package com.vedrunasevilla.tienda.service;

import java.util.List;

import com.vedrunasevilla.tienda.persistance.model.Order;
import com.vedrunasevilla.tienda.persistance.model.OrderItem;
import com.vedrunasevilla.tienda.persistance.model.enumlist.OrderStatus;

public interface OrderService {
    List<Order> getAllOrders();
    Order placeOrder(Long accountId,List<OrderItem> orderItems);
    Order getOrder(Long id);
    List<OrderItem> getOrderItems(Long orderId);
    Order changeStatus(Long id, OrderStatus newStatus);
}
