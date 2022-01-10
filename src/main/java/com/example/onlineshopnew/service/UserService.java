package com.example.onlineshopnew.service;


import com.example.onlineshopnew.dto.UserDto;
import com.example.onlineshopnew.mapper.UserMapper;
import com.example.onlineshopnew.model.User;
import com.example.onlineshopnew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public UserDto create(UserDto userDto) {
        if (userDto.getUsertype().equals("client") || userDto.getUsertype().equals("admin") ) {
//            User user = userMapper.mapToEntity(userDto);
//
//            userRepository.saveUser(user.getEmail(), user.getUsertype(), user.getSurname(), user.getName());
//
//            return userDto;
            User user = userMapper.mapToEntity(userDto);
            User savedUser = userRepository.save(user);

            return userMapper.mapToDto(savedUser);
        }
        else throw new RuntimeException("Usertype must be admin or client.");
    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.getAll();

//        if (users.size() == 0) {
//            System.out.println("este 0");
//            return Collections.singletonList( new UserDto("singurul") );
//        }

        return users.stream().map(u -> userMapper.mapToDto(u)).collect(Collectors.toList());
    }

    @Transactional
    public UserDto editUserType( String email, String type){
        if (userRepository.emailExists(email) == false)
            throw  new RuntimeException("This email doesn't exists");
        else {
            userRepository.editType(email, type);
            return userMapper.mapToDto(userRepository.getUserWithEmail(email));

        }

    }

    public long getIdUser(String email) {
        if (userRepository.emailExists(email) == false)
            throw  new RuntimeException("This email doesn't exists.");
        else
            return userRepository.getId(email);
    }

}

