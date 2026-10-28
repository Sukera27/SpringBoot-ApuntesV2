package com.vedrunasevilla.tienda.controller.dto;

import java.util.Set;

import lombok.Data;

@Data 
public class AccountDto {

    private Long accountId;
    private String accountName;
    private String accountEmail;
    private String accountAddress;
    private Set<ProductDto> wishList;
}
