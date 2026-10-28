package com.vedrunasevilla.tienda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunasevilla.tienda.controller.converter.ProductConverter;
import com.vedrunasevilla.tienda.controller.dto.ProductDto;
import com.vedrunasevilla.tienda.persistance.model.Product;
import com.vedrunasevilla.tienda.service.ProductService;

import lombok.AllArgsConstructor;

@RestController 
@CrossOrigin 
@AllArgsConstructor 
@RequestMapping ("api/v1/products")
public class ProductController {

    ProductService productService;

    ProductConverter productConverter;

    @GetMapping 
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body((productService.getAllProducts().stream().map(productConverter::convertToDto).collect(Collectors.toList())));
    }
    @GetMapping ("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productConverter.convertToDto(productService.getProduct(id)));
    }

}
