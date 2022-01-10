package com.example.onlineshopnew.service;

import com.example.onlineshopnew.mapper.CartItemMapper;
import com.example.onlineshopnew.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    CartItemMapper cartItemMapper;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Transactional
    public String createCartItem(Long cart_id,Long id_produs) {
        if (cartService.getCartForId(cart_id) == false)
            throw new RuntimeException("There is no cart with this id.");

        if (productService.getProductWithId(id_produs) == false)
            throw new RuntimeException("There is no product with this id");

        cartItemRepository.addCartItem(cart_id, id_produs);
        return "ok";

//        CartItem cartItem = cartItemMapper.mapToEntity(cartItemDto);
//
//        cartItemRepository.save(cartItem.);
//
//        car.saveUser(user.getEmail(), user.getUsertype(), user.getSurname(), user.getName());
//
//        return cartItemDto;
    }

    @Transactional
    public  void deleteItems(long cart_id) {
        cartItemRepository.deleteByCartId(cart_id);
    }


    public int getTotalPrice_forcart(long cart_id){
        List<Integer> products = cartItemRepository.getItemsWithCartId(cart_id);
        int s= 0;
        for ( Integer i : products) {
            s += productService.getPrice(i);
        }
        return s;


    }
}
