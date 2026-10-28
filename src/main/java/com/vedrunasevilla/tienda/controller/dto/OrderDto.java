package com.vedrunasevilla.tienda.controller.dto;

import java.time.LocalDate;

import com.vedrunasevilla.tienda.persistance.model.enumlist.OrderStatus;

import lombok.Data;


@Data 
public class OrderDto {

    private Long orderId;

    private Long accountId;

    private LocalDate orderDate;

    private OrderStatus status;
}
