package com.vedrunasevilla.tienda.service;

import java.util.List;

import com.vedrunasevilla.tienda.persistance.model.Order;
import com.vedrunasevilla.tienda.persistance.model.OrderItem;

public interface OrderItemService {
    List <OrderItem> getAllOrderItems();
    OrderItem getOrderItem(Long id);
}
