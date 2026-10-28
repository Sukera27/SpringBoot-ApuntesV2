package com.vedrunasevilla.tienda.controller.converter;

import org.springframework.stereotype.Component;

import com.vedrunasevilla.tienda.controller.dto.OrderItemDto;
import com.vedrunasevilla.tienda.persistance.model.Order;
import com.vedrunasevilla.tienda.persistance.model.OrderItem;
import com.vedrunasevilla.tienda.persistance.model.Product;

@Component 
public class OrderItemConverter {

    public OrderItemDto convertToDto (OrderItem orderItem){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setOrderItemId(orderItem.getOrderItemId());
        if (orderItem.getOrder() != null) {
            orderItemDto.setOrderId(orderItem.getOrder().getId());
        }
        if (orderItem.getProduct() != null) {
            orderItemDto.setProductId(orderItem.getProduct().getProductId());
        }
        orderItemDto.setQuantity(orderItem.getQuantity());
        orderItemDto.setUnitPrice(orderItem.getUnitPrice());
        return orderItemDto;
    }

    public OrderItem convertToEntity (OrderItemDto orderItemDto){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(orderItemDto.getOrderItemId());
        if (orderItemDto.getOrderId() != null) {
            // Solo referencia por id: el pedido ya existe en la BD
            Order order = new Order();
            order.setId(orderItemDto.getOrderId());
            orderItem.setOrder(order);
        }
        if (orderItemDto.getProductId() != null) {
            // Solo referencia por id: el producto ya existe en la BD
            Product product = new Product();
            product.setProductId(orderItemDto.getProductId());
            orderItem.setProduct(product);
        }
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setUnitPrice(orderItemDto.getUnitPrice());
        return orderItem;
    }

}
