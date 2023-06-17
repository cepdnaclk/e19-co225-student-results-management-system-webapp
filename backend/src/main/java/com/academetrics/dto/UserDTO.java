package com.academetrics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data   // getters setters
public class UserDTO {

    private Integer id;
    private String name;
    private String email;
    private String username;
    private String password;

}
