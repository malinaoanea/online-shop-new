package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.CartDto;
import com.example.onlineshopnew.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public CartDto mapToDto(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .total_price(cart.getTotal_price())
                .build();
    }

    public Cart mapToEntity(CartDto cartDto) {
        return Cart.builder()
                .id(cartDto.getId())
                .total_price(cartDto.getTotal_price())
                .build();
    }
}