package com.example.onlineshopnew.controller;

import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.UserMapper;
import com.example.onlineshopnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity
                .ok()
                .body(userService.create(userDto));
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> getAll() {

            return ResponseEntity
                    .ok()
                    .body(userService.getAll());

    }
}
