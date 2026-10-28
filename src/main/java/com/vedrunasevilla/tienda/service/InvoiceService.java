package com.vedrunasevilla.tienda.service;

import java.util.List;

import com.vedrunasevilla.tienda.persistance.model.Invoice;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
    Invoice getInvoice(Long id);
}
