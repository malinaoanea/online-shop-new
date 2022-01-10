package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.AddressDto;
import com.example.onlineshopnew.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDto addressToDto(Address address) {
        return AddressDto.builder()
                .adress(address.getAdress())
                .id(address.getId())
                .user(address.getUser())
                .build();
    }

    public Address mapToEntity(AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .adress(addressDto.getAdress())
                .user(addressDto.getUser())
                .build();
    }
}
