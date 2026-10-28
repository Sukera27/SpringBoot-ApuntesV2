package com.vedrunasevilla.tienda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunasevilla.tienda.exception.NotFoundException;
import com.vedrunasevilla.tienda.persistance.model.Invoice;
import com.vedrunasevilla.tienda.persistance.repository.InvoiceRepository;
import com.vedrunasevilla.tienda.service.InvoiceService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class InvoiceServiceImpl implements InvoiceService {

    InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new NotFoundException("Factura " + id + " no encontrada"));
    }


}
