package com.vedrunasevilla.tienda.persistance.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity 
@Table (name ="invoices")
@Data 
public class Invoice {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "invoice_id")
    Long id;


    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "order_id",referencedColumnName = "order_id",unique = true)
    Order order;

    @Column (name ="invoice_date")
    LocalDate invoiceDate;

    @Column (name = "total_amount")
    Double totalAmount;
}
