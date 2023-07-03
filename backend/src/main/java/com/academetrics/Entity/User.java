package com.academetrics.academetrics.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.academetrics.academetrics.Entity.Department;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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

    private String profilePicture;

//    public void setDeptId(String deptId){
//        this.department.setId(deptId);
//    }

}
