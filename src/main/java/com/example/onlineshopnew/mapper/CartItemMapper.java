package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.model.CartItem;
import com.example.onlineshopnew.dto.CartItemDto;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {
    public CartItemDto mapToDto(CartItem cartItem) {
        return CartItemDto.builder()
                .id(cartItem.getId())
                .cart(cartItem.getCart())
                .build();
    }

    public CartItem mapToEntity(CartItemDto cartItemDto) {
        return CartItem.builder()
                .id(cartItemDto.getId())
                .cart(cartItemDto.getCart())
                .build();
    }
}
