package com.vedrunasevilla.tienda.controller.dto;

import lombok.Data;

@Data 
public class OrderItemDto {

    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private Integer quantity;
    private Double unitPrice;
}
