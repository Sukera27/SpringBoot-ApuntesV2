package com.vedrunasevilla.tienda.service;

import java.util.List;

import com.vedrunasevilla.tienda.persistance.model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(Long id);
}
