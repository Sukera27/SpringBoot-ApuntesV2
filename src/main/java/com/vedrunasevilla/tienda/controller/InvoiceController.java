package com.vedrunasevilla.tienda.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunasevilla.tienda.controller.converter.InvoiceConverter;
import com.vedrunasevilla.tienda.controller.dto.InvoiceDto;
import com.vedrunasevilla.tienda.service.InvoiceService;

import lombok.AllArgsConstructor;

@RestController 
@CrossOrigin 
@AllArgsConstructor 
@RequestMapping ("api/v1/invoices")
public class InvoiceController {

    InvoiceConverter invoiceConverter;

    InvoiceService invoiceService;

    @GetMapping 
    public ResponseEntity<List<InvoiceDto>> getAllInvoices(){
        return ResponseEntity.status(HttpStatus.OK).body((invoiceService.getAllInvoices().stream().map(invoiceConverter::convertToDto).collect(Collectors.toList())));
    }
    @GetMapping ("/{id}")
    public ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceConverter.convertToDto(invoiceService.getInvoice(id)));
    }

}
