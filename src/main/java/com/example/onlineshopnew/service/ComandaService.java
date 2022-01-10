package com.example.onlineshopnew.service;

import com.example.onlineshopnew.mapper.ComandaMapper;
import com.example.onlineshopnew.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ComandaService {

    @Autowired
    ComandaRepository comandaRepository;

    @Autowired
    ComandaMapper comandaMapper;

    @Autowired
    LotService lotService;

    @Transactional
    public String placeComanda(long user_id, long cart_id, int total) {
        comandaRepository.addComanda(cart_id, user_id, total);

        return "Comanda plasata in valoare de " + total;
    }
}
