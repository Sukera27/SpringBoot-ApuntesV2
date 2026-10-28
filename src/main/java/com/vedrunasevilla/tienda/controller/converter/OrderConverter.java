package com.vedrunasevilla.tienda.controller.converter;

import org.springframework.stereotype.Component;

import com.vedrunasevilla.tienda.controller.dto.OrderDto;
import com.vedrunasevilla.tienda.persistance.model.Account;
import com.vedrunasevilla.tienda.persistance.model.Order;

@Component 
public class OrderConverter {

    public OrderDto convertToDto (Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getId());
        if (order.getAccount() != null) {
            orderDto.setAccountId(order.getAccount().getAccountId());
        }
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }

    public Order convertToEntity (OrderDto orderDto){
        Order order = new Order();
        order.setId(orderDto.getOrderId());
        if (orderDto.getAccountId() != null) {
            // Solo referencia por id: la cuenta ya existe en la BD
            Account account = new Account();
            account.setAccountId(orderDto.getAccountId());
            order.setAccount(account);
        }
        order.setOrderDate(orderDto.getOrderDate());
        order.setStatus(orderDto.getStatus());
        return order;
    }

}
