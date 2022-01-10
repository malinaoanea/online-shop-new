package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.dto.ProductDto;
import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.UserMapper;
import com.example.onlineshopnew.service.ProductService;
import com.example.onlineshopnew.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @Test
    @DisplayName("Testing creating the product.")
    void createUProductGood() throws Exception {
//        ProductDto dto  = ProductDto.builder().name("test").price(100).category_id(1).build();
//        dto.setId(99L);
//        when(productService.create(any())).thenReturn(dto);
//        String t = dto.tostring();
//
//        MvcResult result = mockMvc.perform(post("/users/createUser")
//                        .content(t)
//                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//                .andReturn();
//
//
//        //Assert
//        assertThat(result.getResponse().getContentAsString()).isEqualTo(t);
    }
}