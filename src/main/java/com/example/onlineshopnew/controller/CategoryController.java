package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.dto.CategoryDto;
import com.example.onlineshopnew.dto.ProductDto;
import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.CategoryMapper;
import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.service.CategoryService;
import com.example.onlineshopnew.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<String>> getAll() {
        try {
            return ResponseEntity
                    .ok()
                    .body(categoryService.getCategories());
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .ok()
                .body(categoryService.create(categoryDto));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<ProductDto>> getProductsForCategory(@RequestParam(name = "category") String category) {

        long id = categoryService.getCategoryId(category);

        try {
            return ResponseEntity
                    .ok()
                    .body(productService.getProductOfCtegory(id));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
