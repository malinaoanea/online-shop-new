package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.dto.ProductDto;
import com.example.onlineshopnew.mapper.ProductMapper;
import com.example.onlineshopnew.model.Product;
import com.example.onlineshopnew.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(
            @RequestBody ProductDto ProductDto) {
        Product savedProduct = productService.create(
                productMapper.mapToEntity(ProductDto));
        return ResponseEntity
                .created(URI.create("/products/" + String.valueOf(savedProduct.getId())))
                .body(savedProduct);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getAll() {

            return ResponseEntity
                    .ok()
                    .body(productService.getProducts());

    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam(name = "product_id") long product_id) {

        return ResponseEntity
                .ok()
                .body(productService.deleteWithId(product_id));
    }


}
