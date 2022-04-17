package com.akmal.usermanagementsystem.entity;

import com.akmal.usermanagementsystem.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailId;

    public User(UserDto createUserDto) {
        this.firstName = createUserDto.getFirstName();
        this.lastName = createUserDto.getLastName();
        this.emailId = createUserDto.getEmailId();
    }
}
