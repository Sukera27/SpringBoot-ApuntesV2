package com.vedrunasevilla.tienda.controller.converter;

import org.springframework.stereotype.Component;

import com.vedrunasevilla.tienda.controller.dto.InvoiceDto;
import com.vedrunasevilla.tienda.persistance.model.Invoice;
import com.vedrunasevilla.tienda.persistance.model.Order;

@Component 
public class InvoiceConverter {

    public InvoiceDto convertToDto (Invoice invoice){
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setInvoiceId(invoice.getId());
        if (invoice.getOrder() != null) {
            invoiceDto.setOrderId(invoice.getOrder().getId());
        }
        invoiceDto.setInvoiceDate(invoice.getInvoiceDate());
        invoiceDto.setTotalAmount(invoice.getTotalAmount());
        return invoiceDto;
    }

    public Invoice convertToEntity (InvoiceDto invoiceDto){
        Invoice invoice = new Invoice();
        invoice.setId(invoiceDto.getInvoiceId());
        if (invoiceDto.getOrderId() != null) {
            // Solo referencia por id: el pedido ya existe en la BD
            Order order = new Order();
            order.setId(invoiceDto.getOrderId());
            invoice.setOrder(order);
        }
        invoice.setInvoiceDate(invoiceDto.getInvoiceDate());
        invoice.setTotalAmount(invoiceDto.getTotalAmount());
        return invoice;
    }

}
