package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.dto.CategoryDto;
import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.CategoryMapper;
import com.example.onlineshopnew.mapper.UserMapper;
import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.service.CategoryService;
import com.example.onlineshopnew.service.ProductService;
import com.example.onlineshopnew.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTest {
    @MockBean
    private CategoryService categoryService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryMapper categoryMapper;

    @MockBean
    private ProductService productService;


    @Test
    void getAll() {
    }

    @Test
    @DisplayName("Testing creating the category.")
    void createGood() throws Exception {
//        UserDto dto = UserDto.builder().email("mali@gmail.com").usertype("client").name("malina").surname("o").build();
        CategoryDto dto = CategoryDto.builder().category_name("test").build();
        dto.setId(99L);
        when(categoryService.create(any())).thenReturn(dto);
        String t = dto.tostring();
        String con = "{" + '"' + "category_name" + '"' + ":" + '"' + "test" + '"' + "}";
        System.out.println(con);
        MvcResult result = mockMvc.perform(post("/categories/createCategory")
                        .content(con)
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andReturn();


        //Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo(t);
    }

    @Test
    void getProductsForCategory() {
    }
}