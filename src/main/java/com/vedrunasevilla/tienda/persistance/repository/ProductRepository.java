package com.vedrunasevilla.tienda.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunasevilla.tienda.persistance.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
