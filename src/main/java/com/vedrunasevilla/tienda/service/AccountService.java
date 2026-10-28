package com.vedrunasevilla.tienda.service;

import java.util.List;

import com.vedrunasevilla.tienda.persistance.model.Account;

public interface AccountService {

    List<Account> getAllAccounts();

    Account gettAccount(Long id);
}
