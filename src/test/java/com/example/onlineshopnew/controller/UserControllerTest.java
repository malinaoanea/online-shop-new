package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.UserMapper;
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
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserMapper userMapper;

    @Test
    @DisplayName("Testing creating the user.")
    void createUserGood() throws Exception {
        UserDto dto = UserDto.builder().email("mali@gmail.com").usertype("client").name("malina").surname("o").build();
        dto.setId(99L);
        when(userService.create(any())).thenReturn(dto);
        String t = dto.tostring();

        MvcResult result = mockMvc.perform(post("/users/createUser")
                        .content(t)
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andReturn();


        //Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo(t);
    }



//    @Test
//    @DisplayName("Get users - happy flow")
//    void test_getUsers() throws Exception {
//        when(userService.getAll()).thenReturn(List<UserDto>);
//
////        mockMvc.perform(get("/users/allusers"))
////                .andExpect(status().isOk())
////                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }

    @Test
    void getAll() {
    }
}