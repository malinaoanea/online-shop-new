package com.example.onlineshopnew.dto;

import com.example.onlineshopnew.model.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LotDto {
    private long id;
    private Product product;
    private int number;
    private String nume_lot;

    public LotDto(long id) {
        this.id = id;
    }
}