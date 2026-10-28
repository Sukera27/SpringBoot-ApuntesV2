package com.vedrunasevilla.tienda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunasevilla.tienda.exception.NotFoundException;
import com.vedrunasevilla.tienda.persistance.model.Product;
import com.vedrunasevilla.tienda.persistance.repository.ProductRepository;
import com.vedrunasevilla.tienda.service.ProductService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Producto " + id + " no encontrado"));
    }

}
