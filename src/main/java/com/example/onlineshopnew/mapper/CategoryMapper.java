package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.CategoryDto;
import com.example.onlineshopnew.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto mapToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .category_name(category.getCategory_name())
                .build();
    }

    public Category mapToEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .category_name(categoryDto.getCategory_name())
                .build();
    }
}
