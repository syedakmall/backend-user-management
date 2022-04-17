package com.akmal.usermanagementsystem.service;

import com.akmal.usermanagementsystem.dto.DeleteUserDto;
import com.akmal.usermanagementsystem.dto.UserDto;
import com.akmal.usermanagementsystem.dto.UsersDto;
import com.akmal.usermanagementsystem.entity.User;
import com.akmal.usermanagementsystem.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ObjectMapper objectMapper;

    public User saveUser(UserDto userDto) {
        User userEntity = new User(userDto);
        userRepo.save(userEntity);
        return userEntity;
    }

    public UsersDto getAllUsers() {
        List<User> userEntityList = userRepo.findAll();
        return new UsersDto(userEntityList);
    }

    public DeleteUserDto deleteUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new IllegalStateException("Not Found"));
        userRepo.delete(user);
        return new DeleteUserDto(true, userId);
    }

    public User getUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException("Not Found"));
        return user;
    }

    public User updateUser(Long userId, String updateUserDto) throws JsonProcessingException {
        User userEntity = userRepo.findById(userId).orElseThrow(() -> new IllegalStateException("Not Found"));
        User user = objectMapper.readerForUpdating(userEntity).readValue(updateUserDto);
        if (user.getUserId() == null) return null;
        userRepo.save(user);
        return userEntity;
    }
}
