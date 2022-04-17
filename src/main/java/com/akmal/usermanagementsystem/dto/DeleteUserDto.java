package com.akmal.usermanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteUserDto {
    private Boolean deleted;
    private Long id;
}
