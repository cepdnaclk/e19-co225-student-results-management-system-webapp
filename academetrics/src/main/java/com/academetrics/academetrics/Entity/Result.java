package com.academetrics.academetrics.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    private Long id;
    private String regNo;
    private String grade;

    // Constructors
    public Result() {
    }

    public Result(Long id, String regNo, String grade) {
        this.id = id;
        this.regNo = regNo;
        this.grade = grade;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

