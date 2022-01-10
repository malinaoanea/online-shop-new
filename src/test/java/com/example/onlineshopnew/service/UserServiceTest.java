package com.example.onlineshopnew.service;

import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.UserMapper;
import com.example.onlineshopnew.model.Category;
import com.example.onlineshopnew.model.User;
import com.example.onlineshopnew.repository.CategoryRepository;
import com.example.onlineshopnew.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test") //the test will use the configuration from the application-test.properties file
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Create user - happy flow")
    void create() {
        String userType = new String("client");
        User user = new User("malina", "oanea", userType, "mail@gmail.com");
        long i = 1;
        UserDto userDto = new UserDto(i, "malina", "oanea", userType, "mail@gmail.com");

        when(userMapper.mapToEntity(userDto)).thenReturn(user);
        when(userMapper.mapToDto(user)).thenReturn(userDto);

        UserDto result = userService.create(userDto);

        assertThat(result).isNotNull();
        verify(userMapper, times(1)).mapToEntity(userDto);
        verify(userRepository, times(1)).save(user);

        verifyNoMoreInteractions(userMapper, userRepository);
    }



    @Test
    @DisplayName("Create user - sad flow")
    void createBad() {
        String userType = new String("client");
        User user = new User("malina", "oanea", userType, "mail@gmail.com");
        long i = 1;
        UserDto userDto = new UserDto(i, "malina", "oanea", userType, "mail@gmail.com");

        when(userMapper.mapToEntity(userDto)).thenReturn(user);
        when(userMapper.mapToDto(user)).thenReturn(userDto);

        UserDto result = userService.create(userDto);

        assertThat(result).isNotNull();
        verify(userMapper, times(1)).mapToEntity(userDto);
        verify(userRepository, times(1)).save(user);

        verifyNoMoreInteractions(userMapper, userRepository);
    }

    @Test
    void getAll() {
    }

    @Test
    void editUserType() {
    }

    @Test
    void getIdUser() {
    }
}