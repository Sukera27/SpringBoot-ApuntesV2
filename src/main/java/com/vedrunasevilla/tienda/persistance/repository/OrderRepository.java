package com.vedrunasevilla.tienda.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunasevilla.tienda.persistance.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
