package com.example.onlineshopnew.service;

import com.example.onlineshopnew.dto.CategoryDto;
import com.example.onlineshopnew.dto.ProductDto;
import com.example.onlineshopnew.mapper.CategoryMapper;
import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.model.User;
import com.example.onlineshopnew.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductService productService;

    public List<String> getCategories() {
        return categoryRepository.getCategories();

    }

    public Long getCategoryId(String nume) {
        return categoryRepository.getPr(nume);
    }

    public CategoryDto create(CategoryDto categoryDto) {
        if (categoryDto.getCategory_name() == null)
            throw new RuntimeException("Category already exists.");
        if (categoryRepository.categExists(categoryDto.getCategory_name()))
            throw new RuntimeException("Category already exists.");

        Category category = categoryMapper.mapToEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.mapToDto(savedCategory);
    }

    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    public List<ProductDto> getProductsFCatgeory(String category) {
        Long id = categoryRepository.getPr(category);
        System.out.println("Id categorie " +  id + "!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<ProductDto> products = productService.getProductOfCtegory(id);

        return products;
    }
}
