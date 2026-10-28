package com.vedrunasevilla.tienda.persistance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@Table (name = "products")
@NoArgsConstructor 
public class Product {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "product_id")
    private Long productId;
    @Column (name = "product_name")
    private String productName;
    @Column (name = "product_code")
    private String productCode;
    @Column (name = "product_description")
    private String productDescription;
    @Column (name = "product_price")
    private Double productPrice;

}
