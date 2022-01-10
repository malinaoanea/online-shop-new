package com.example.onlineshopnew.dto;

import com.example.onlineshopnew.model.Cart;
import com.example.onlineshopnew.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComandaDto {
    long id;
    Cart cart;
    User user;
    int total_price;
}
