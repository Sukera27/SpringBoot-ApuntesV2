package com.vedrunasevilla.tienda.controller.converter;

import org.springframework.stereotype.Component;

import com.vedrunasevilla.tienda.controller.dto.ProductDto;
import com.vedrunasevilla.tienda.persistance.model.Product;

@Component 
public class ProductConverter {

    public ProductDto convertToDto (Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setProductCode(product.getProductCode());
        productDto.setProductDescription(product.getProductDescription());
        productDto.setProductPrice(product.getProductPrice());
        return productDto;
    }

    public Product convertToEntity (ProductDto productDto){
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setProductCode(productDto.getProductCode());
        product.setProductDescription(productDto.getProductDescription());
        product.setProductPrice(productDto.getProductPrice());
        return product;
    }

}
