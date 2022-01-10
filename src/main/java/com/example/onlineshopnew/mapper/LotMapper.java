package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.LotDto;
import com.example.onlineshopnew.model.Lot;
import org.springframework.stereotype.Component;

@Component
public class LotMapper {
    public LotDto lotToDto(Lot lot) {
        return LotDto.builder()
                .number(lot.getNumber())
                .id(lot.getId())
                .nume_lot(lot.getNume_lot())
                .build();
    }

    public Lot mapToEntity(LotDto lotDto) {
        return Lot.builder()
                .id(lotDto.getId())
                .number(lotDto.getNumber())
                .nume_lot(lotDto.getNume_lot())
                .build();
    }
}
