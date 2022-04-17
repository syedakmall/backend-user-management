package com.akmal.usermanagementsystem.controller;

import com.akmal.usermanagementsystem.dto.DeleteUserDto;
import com.akmal.usermanagementsystem.dto.UserDto;
import com.akmal.usermanagementsystem.dto.UsersDto;
import com.akmal.usermanagementsystem.entity.User;
import com.akmal.usermanagementsystem.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("save")
    public User saveUser(@RequestBody UserDto createUserDto) {
        return userService.saveUser(createUserDto);
    }

    @GetMapping("all")
    public UsersDto getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("user/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("user/{userId}")
    public DeleteUserDto deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }

    @PutMapping("user/update/{userId}")
    public User updateUser(@RequestBody String updateUserDto, @PathVariable Long userId) throws JsonProcessingException {
        return userService.updateUser(userId, updateUserDto);
    }
}
