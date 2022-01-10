package com.example.onlineshopnew.service;

import com.example.onlineshopnew.mapper.LotMapper;
import com.example.onlineshopnew.model.Lot;
import com.example.onlineshopnew.repository.LotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LotService {
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private LotMapper lotMapper;

    public int getNumberofProducts(long id) {
        return lotRepository.getNumberofProductItems(id);
    }

    @Transactional
    public Lot create(Lot lot) {
        Optional<Lot> existingDestinationSameName = lotRepository.findByName(lot.getNume_lot());
        existingDestinationSameName.ifPresent(e -> {
            throw new RuntimeException("Lot already exists.");
        });
        return lotRepository.save(lot);
    }

    public Optional<Lot> getById(long id) {
        return lotRepository.findById(id);
    }
}
