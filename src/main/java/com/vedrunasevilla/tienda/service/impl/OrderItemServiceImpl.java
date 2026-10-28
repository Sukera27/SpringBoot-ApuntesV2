package com.vedrunasevilla.tienda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunasevilla.tienda.exception.NotFoundException;
import com.vedrunasevilla.tienda.persistance.model.OrderItem;
import com.vedrunasevilla.tienda.persistance.repository.OrderItemRepository;
import com.vedrunasevilla.tienda.service.OrderItemService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class OrderItemServiceImpl implements OrderItemService {

    OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItem(Long id) {
        return orderItemRepository.findById(id).orElseThrow(() -> new NotFoundException("Línea de pedido " + id + " no encontrada"));
    }
}