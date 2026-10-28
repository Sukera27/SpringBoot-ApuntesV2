package com.vedrunasevilla.tienda.controller.dto;

import lombok.Data;

@Data 
public class ProductDto {

    private Long productId;
    private String productName;
    private String productCode;
    private String productDescription;
    private Double productPrice;
}
