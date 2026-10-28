package com.vedrunasevilla.tienda.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunasevilla.tienda.persistance.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
