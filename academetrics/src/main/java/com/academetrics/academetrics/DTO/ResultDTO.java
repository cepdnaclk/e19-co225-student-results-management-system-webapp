package com.academetrics.academetrics.DTO;

public class ResultDTO {
    private String regNo;
    private String grade;

    // Constructors
    public ResultDTO() {
    }

    public ResultDTO(String regNo, String grade) {
        this.regNo = regNo;
        this.grade = grade;
    }

    // Getters
    public String getRegNo() {
        return regNo;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
