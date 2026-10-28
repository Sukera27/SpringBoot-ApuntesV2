package com.vedrunasevilla.tienda.persistance.model;


import java.time.LocalDate;

import com.vedrunasevilla.tienda.persistance.model.enumlist.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name ="orders")
@NoArgsConstructor 
@Getter 
@Setter 
public class Order {

    @Id     
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "order_id")
    Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name ="account_id", referencedColumnName = "account_id")
    Account account;

    @Column (name = "order_date")
    LocalDate orderDate;
    @Enumerated (EnumType.STRING)
    @Column (name = "status")
    OrderStatus status;
}
