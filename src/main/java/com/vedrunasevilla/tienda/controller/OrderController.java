package com.vedrunasevilla.tienda.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunasevilla.tienda.controller.converter.OrderConverter;
import com.vedrunasevilla.tienda.controller.converter.OrderItemConverter;
import com.vedrunasevilla.tienda.controller.dto.OrderDto;
import com.vedrunasevilla.tienda.controller.dto.OrderItemDto;
import com.vedrunasevilla.tienda.persistance.model.Order;
import com.vedrunasevilla.tienda.persistance.model.OrderItem;
import com.vedrunasevilla.tienda.persistance.model.enumlist.OrderStatus;
import com.vedrunasevilla.tienda.service.OrderService;

import lombok.AllArgsConstructor;

@RestController 
@CrossOrigin 
@AllArgsConstructor 
@RequestMapping ("api/v1/orders")
public class OrderController {

    OrderConverter orderConverter;

    OrderService orderService;

    OrderItemConverter orderItemConverter;

    @GetMapping 
    public ResponseEntity<List<OrderDto>> getAllOrder (){
        return ResponseEntity.status(HttpStatus.OK).body((orderService.getAllOrders().stream().map(orderConverter::convertToDto).collect(Collectors.toList())));
    }
    @GetMapping ("/{orderId}/items")
    public ResponseEntity<List<OrderItemDto>> getOrderItems(@PathVariable Long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderItems(orderId).stream().map(orderItemConverter::convertToDto).collect(Collectors.toList()));
    }

    @PostMapping ("/{accountId}")
    public ResponseEntity<OrderDto> placeOrder(@PathVariable Long accountId,@RequestBody List<OrderItemDto> orderItemDtos){
        List<OrderItem> items = orderItemDtos.stream().map(orderItemConverter::convertToEntity).collect(Collectors.toList());
        Order order = orderService.placeOrder(accountId, items);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderConverter.convertToDto(order));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(orderConverter.convertToDto(orderService.getOrder(id)));
    }
    @PatchMapping ("/{id}/status")
    public ResponseEntity<OrderDto> changeOrderStatus(@PathVariable Long id, @RequestParam OrderStatus newOrderStatus ){
        return ResponseEntity.status(HttpStatus.OK).body(orderConverter.convertToDto(orderService.changeStatus(id, newOrderStatus)));
    }


}
