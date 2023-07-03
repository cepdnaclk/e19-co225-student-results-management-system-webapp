package com.academetrics.academetrics.DTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegistrationDTO {
    private int id;
    private String userName;
    private String password;
    private String mail;
    private String honorific;
    private String initials;
    private String lastName;
    private String role;
    private String contact;
    private String deptId;
    private String profilePicture;
}
