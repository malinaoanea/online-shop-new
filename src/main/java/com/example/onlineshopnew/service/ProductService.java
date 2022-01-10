package com.example.onlineshopnew.service;


import com.example.onlineshopnew.dto.ProductDto;
import com.example.onlineshopnew.mapper.ProductMapper;
import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.model.Lot;
import com.example.onlineshopnew.model.Product;
import com.example.onlineshopnew.model.User;
import com.example.onlineshopnew.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;
//
//    @Autowired
//    private CategoryService categoryService;

    @Autowired
    private LotService lotService;

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.getAll();
        return products.stream().map(u -> productMapper.productToDto(u)).collect(Collectors.toList());
    }

    public List<ProductDto> getProductOfCtegory(long id) {
        List<Product> products = productRepository.getProductByCategory(id);
        return products.stream().map(u -> productMapper.productToDto(u)).collect(Collectors.toList());
    }

    public Product create(Product product) {
        Optional<Product> existingProductSameName = productRepository.findByName(product.getName());
        existingProductSameName.ifPresent(e -> {
            throw new RuntimeException("Product already exists.");
        });

        System.out.println("!!!!" + product.getLot().getId());

        Optional<Lot> lot = lotService.getById(product.getLot().getId());
        if (lot.isEmpty() ){
            throw new RuntimeException("Lot doesn't exist.");
        }

        return productRepository.save(product);
    }

    public  Optional<Product> getProductWithName(String name) {
        return productRepository.findByName(name);
    }
    public int getPrice(Integer id) { return productRepository.getPrice(id);}
    public boolean getProductWithId(long id) {
        return productRepository.existsById(id);
    }
    public String deleteWithId(long product_id) {
        productRepository.deleteById(product_id);
        return "Product with id " + product_id + " deleted.";
    }


}

