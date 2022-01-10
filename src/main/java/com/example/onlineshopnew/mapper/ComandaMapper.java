package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.ComandaDto;
import com.example.onlineshopnew.model.Comanda;
import org.springframework.stereotype.Component;

@Component
public class ComandaMapper {
    public ComandaDto mapToDto(Comanda comanda) {
        return ComandaDto.builder()
                .cart(comanda.getCart())
                .user(comanda.getCustomer())
                .id(comanda.getId())
                .total_price(comanda.getTotal())
                .build();
    }

    public Comanda mapToEntity(ComandaDto comandaDto) {
        return Comanda.builder()
                .id(comandaDto.getId())
                .customer(comandaDto.getUser())
                .cart(comandaDto.getCart())
                .total(comandaDto.getTotal_price())
                .build();
    }
}
