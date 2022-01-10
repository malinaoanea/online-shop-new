package com.example.onlineshopnew.mapper;

import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto mapToDto(User user) {
        return UserDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .id(user.getId())
                .usertype(user.getUsertype())
                .build();
    }

    public User mapToEntity(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .id(userDto.getId())
                .usertype(userDto.getUsertype())
                .build();
    }



}
