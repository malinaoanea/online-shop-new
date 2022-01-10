package com.example.onlineshopnew.service;

import com.example.onlineshopnew.mapper.AddressMapper;
import com.example.onlineshopnew.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository adresRepository;

    @Autowired
    private AddressMapper addressMapper;

    public String getAddress(int id) {
        return adresRepository.getAdressOfClient(id);
    }
}
