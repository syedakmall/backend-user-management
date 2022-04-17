package com.akmal.usermanagementsystem.dto;

import com.akmal.usermanagementsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private List<User> users;
}
