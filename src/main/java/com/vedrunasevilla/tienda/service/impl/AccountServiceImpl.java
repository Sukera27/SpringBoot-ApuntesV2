package com.vedrunasevilla.tienda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedrunasevilla.tienda.exception.NotFoundException;
import com.vedrunasevilla.tienda.persistance.model.Account;
import com.vedrunasevilla.tienda.persistance.repository.AccountRepository;
import com.vedrunasevilla.tienda.service.AccountService;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class AccountServiceImpl implements AccountService{

    AccountRepository accountRepository;
    
    @Override
    public List<Account> getAllAccounts() {
       return accountRepository.findAll();
    }

    @Override
    public Account gettAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Cuenta " + id + " no encontrada"));
    }

}
