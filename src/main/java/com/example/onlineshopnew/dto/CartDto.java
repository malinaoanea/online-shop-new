package com.example.onlineshopnew.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private long id;
    private int total_price;
}
