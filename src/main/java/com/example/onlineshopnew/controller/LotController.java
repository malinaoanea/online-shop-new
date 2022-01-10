package com.example.onlineshopnew.controller;


import com.example.onlineshopnew.dto.LotDto;
import com.example.onlineshopnew.exception.ProductNotFoundException;
import com.example.onlineshopnew.mapper.LotMapper;
import com.example.onlineshopnew.model.Lot;
import com.example.onlineshopnew.model.Product;
import com.example.onlineshopnew.service.LotService;
import com.example.onlineshopnew.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/loturi")
public class LotController {
    @Autowired
    private LotService lotService;

    @Autowired
    private LotMapper lotMapper;

    @Autowired
    ProductService productService;

    @GetMapping("/thisproducts")
    public ResponseEntity<Integer> getNumber(@RequestParam(name = "name") String name) {

            Optional<Product> getproduct = productService.getProductWithName(name);

            if(getproduct.isEmpty()) {
                throw new ProductNotFoundException(name);
            }
            Product product = getproduct.get();
            return ResponseEntity
                    .ok()
                    .body(lotService.getNumberofProducts(product.getId()));

    }

    @PostMapping
    public ResponseEntity<Lot> create(
            @RequestBody LotDto lotDto) {
        Lot savedLot = lotService.create(
                lotMapper.mapToEntity(lotDto));
        return ResponseEntity
                .created(URI.create("/Lots/" + savedLot.getId()))
                .body(savedLot);
    }


}
