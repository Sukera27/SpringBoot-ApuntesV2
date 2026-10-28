package com.vedrunasevilla.tienda.controller.converter;
import java.util.HashSet;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.vedrunasevilla.tienda.controller.dto.AccountDto;
import com.vedrunasevilla.tienda.controller.dto.ProductDto;
import com.vedrunasevilla.tienda.persistance.model.Account;
import com.vedrunasevilla.tienda.persistance.model.Product;

import lombok.AllArgsConstructor;

@Component 
@AllArgsConstructor 
public class AccountConverter {

    final ProductConverter productConverter;

    public AccountDto convertToDto (Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountId(account.getAccountId());
        accountDto.setAccountName(account.getAccountName());
        accountDto.setAccountEmail(account.getAccountEmail());
        accountDto.setAccountAddress(account.getAccountAddress());
        if(account.getWishList() != null){
            Set <ProductDto> wishListDto = new HashSet<>();
            for ( Product whises : account.getWishList() ){
                wishListDto.add(productConverter.convertToDto(whises));
            }
            accountDto.setWishList(wishListDto);
        }
        return accountDto;
    }

    public Account convertToEntity (AccountDto accountDto){
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setAccountName(accountDto.getAccountName());
        account.setAccountEmail(accountDto.getAccountEmail());
        account.setAccountAddress(accountDto.getAccountAddress());
        if (accountDto.getWishList() != null) {
        Set<Product> wishList = new HashSet<>();
        for (ProductDto productDto : accountDto.getWishList()) {
            wishList.add(productConverter.convertToEntity(productDto));
        }
        account.setWishList(wishList);
        }

        return account;
    }

}
