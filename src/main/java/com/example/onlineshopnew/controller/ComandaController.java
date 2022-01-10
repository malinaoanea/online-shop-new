package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.service.CartItemService;
import com.example.onlineshopnew.service.CartService;
import com.example.onlineshopnew.service.ComandaService;
import com.example.onlineshopnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comenzi")
public class ComandaController {

    @Autowired
    ComandaService comandaService;

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

    @PostMapping("/placeComandaFor")
    public ResponseEntity<String> addToCart(@RequestParam(name = "email") String email) {

        Long email_id = userService.getIdUser(email);
        Long cart_id = cartService.getCartIdForClient(email_id);

        // in momentul in care comanda este plasata, itemurile din cart se sterg


        int total = cartItemService.getTotalPrice_forcart(cart_id);
        cartItemService.deleteItems(cart_id);

        return ResponseEntity
                .ok()
                .body(comandaService.placeComanda(email_id, cart_id, total));
    }

    @GetMapping("/aici")
    public ResponseEntity<String> hei(){
        return ResponseEntity
                .ok()
                .body("hei");
    }
}
