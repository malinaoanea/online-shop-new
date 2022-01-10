package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AddressController {
    @Autowired
    private AddressService adressService;

    @GetMapping("/getadresa/{id}")
    public ResponseEntity<String> getAll(@PathVariable String id) {

            return ResponseEntity
                    .ok()
                    .body(adressService.getAddress(Integer.parseInt(id)));

    }
}
