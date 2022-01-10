package com.example.onlineshopnew.exception;

import com.example.onlineshopnew.model.Product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super("The product with name " + name + " doesn't exist.");
    }
}
