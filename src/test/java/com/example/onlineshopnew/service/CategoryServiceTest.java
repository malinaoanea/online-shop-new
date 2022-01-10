package com.example.onlineshopnew.service;

import com.example.onlineshopnew.mapper.CategoryMapper;
import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test") //the test will use the configuration from the application-test.properties file
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class CategoryServiceTest {
    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Test
    void getCategories() {
    }


    @Test
    @DisplayName("Create category - happy flow")
    void create() {
//        Category category = new Category("test");
//        Category savedCategory = new Category(1, "test");
//
//        when(categoryRepository.categExists(category.getCategory_name())).thenReturn(false);
//        when(categoryRepository.save(category)).thenReturn(savedCategory);
//
//        Category result = categoryService.create(category);
//
//        assertNotNull(result.getId());
//        assertEquals(savedCategory.getId(), result.getId());
//        assertEquals(savedCategory.getCategory_name(), result.getCategory_name());
    }

    @Test
    @DisplayName("Create category - sad flow")
    void createBad() {
//        Category category = null;
//
//        //act (when)
//        RuntimeException exception = assertThrows(RuntimeException.class,
//                () -> categoryService.create(category));
//
//        //assert (then)
//        assertEquals("Category already exists.",
//                exception.getMessage());
    }

//    @Test
//    void findById() {
//    }
}