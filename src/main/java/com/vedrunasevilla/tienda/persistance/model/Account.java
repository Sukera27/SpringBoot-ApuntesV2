package com.vedrunasevilla.tienda.persistance.model;

import java.util.List;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "accounts")
@NoArgsConstructor
@Getter 
@Setter 
public class Account {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "account_id")
    private Long accountId;
    @Column (name = "account_name")
    private String accountName;
    @Column (name = "account_email")
    private String accountEmail;
    @Column (name = "account_address")
    private String accountAddress;

    @ManyToMany ( fetch = FetchType.LAZY)
    @JoinTable (name = "wishlists", joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "account_id")}
    , inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    Set<Product> wishList;

    @OneToMany (mappedBy = "account" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List <Order> orderList;
}
