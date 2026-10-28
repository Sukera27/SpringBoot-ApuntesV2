package com.vedrunasevilla.tienda.controller.dto;

import java.time.LocalDate;

import lombok.Data;


@Data 
public class InvoiceDto {

    private Long invoiceId;

    private Long orderId;

    private LocalDate invoiceDate;

    private Double totalAmount;

}
