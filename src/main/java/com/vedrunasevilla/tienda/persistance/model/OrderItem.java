package com.vedrunasevilla.tienda.persistance.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "order_items")
@NoArgsConstructor
@Data 
public class OrderItem {

    @Id 
    @Column (name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn (name = "order_id" , referencedColumnName="order_id")
    private Order order;
    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id" , referencedColumnName="product_id")
    private Product product;
    @Column (name = "quantity")
    private Integer quantity;
    @Column (name = "unit_price")
    private Double unitPrice;

}
