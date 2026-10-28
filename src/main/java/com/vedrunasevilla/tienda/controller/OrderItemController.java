package com.vedrunasevilla.tienda.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunasevilla.tienda.controller.converter.OrderItemConverter;
import com.vedrunasevilla.tienda.controller.dto.OrderItemDto;
import com.vedrunasevilla.tienda.service.OrderItemService;

import lombok.AllArgsConstructor;

@RestController 
@CrossOrigin 
@AllArgsConstructor 
@RequestMapping ("api/v1/order-items")
public class OrderItemController {

    OrderItemConverter orderItemConverter;

    OrderItemService orderItemService;

    @GetMapping 
    public ResponseEntity<List<OrderItemDto>> getAllOI(){
        return  ResponseEntity.status(HttpStatus.OK).body(orderItemService.getAllOrderItems().stream().map(orderItemConverter::convertToDto).collect(Collectors.toList()));
    }
    @GetMapping ("{id}")
    public ResponseEntity<OrderItemDto> getOIById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderItemConverter.convertToDto(orderItemService.getOrderItem(id)));
    }

}
