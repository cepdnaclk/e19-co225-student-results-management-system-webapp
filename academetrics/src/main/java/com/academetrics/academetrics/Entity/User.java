package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.academetrics.academetrics.Entity.Department;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="user")
public class User {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Id
    @NotNull(message = "Username may not be null")
    @NotBlank(message = "Username may not be blank")
    @NotEmpty(message = "Username may not be empty")
    private String userName;
    private String password;
    private String mail;
    private String honorific;
    private String initials;
    private String lastName;
    private String role;
    private String contact;

    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;
}
