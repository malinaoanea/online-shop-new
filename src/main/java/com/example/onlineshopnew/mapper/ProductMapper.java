package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.ProductDto;
import com.example.onlineshopnew.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto productToDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .category(product.getCategory())
                .lot(product.getLot())
                .build();
    }

    public Product mapToEntity(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .lot(productDto.getLot())
                .category(productDto.getCategory())
                .build();
    }
}

