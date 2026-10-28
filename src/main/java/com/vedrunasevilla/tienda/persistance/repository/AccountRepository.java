package com.vedrunasevilla.tienda.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vedrunasevilla.tienda.persistance.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
