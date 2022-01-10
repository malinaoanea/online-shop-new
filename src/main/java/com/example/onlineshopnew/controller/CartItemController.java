package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.service.CartItemService;
import com.example.onlineshopnew.service.CartService;
import com.example.onlineshopnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartItems")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestParam(name = "product_id") long product_id, @RequestParam(name = "email") String email) {

        Long email_id = userService.getIdUser(email);
        Long cart_id = cartService.getCartIdForClient(email_id);
        return ResponseEntity
                .ok()
                .body(cartItemService.createCartItem(cart_id, product_id));
    }
}
