package com.vedrunasevilla.tienda.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vedrunasevilla.tienda.controller.converter.AccountConverter;
import com.vedrunasevilla.tienda.controller.dto.AccountDto;
import com.vedrunasevilla.tienda.service.AccountService;

import lombok.AllArgsConstructor;

@RestController 
@CrossOrigin 
@AllArgsConstructor 
@RequestMapping ("/api/v1/accounts")
public class AccountController {

    AccountConverter accountConverter;

    AccountService accountService;

    @GetMapping 
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccounts().stream().map(accountConverter::convertToDto).collect(Collectors.toList()));
    }
    @GetMapping ("{id}")
    public ResponseEntity<AccountDto> getAccountByid(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(accountConverter.convertToDto(accountService.gettAccount(id)));
    }
}
