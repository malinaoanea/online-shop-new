package com.example.onlineshopnew.dto;

import com.example.onlineshopnew.model.Cart;
import com.example.onlineshopnew.model.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private long id;
    private Product product;
    private Cart cart;
}

