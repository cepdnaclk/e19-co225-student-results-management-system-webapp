package com.academetrics.academetrics.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    private String userName;
    private String mail;
    private String honorific;
    private String initials;
    private String lastName;
    private String contact;
    private String deptName;
    private int academicYear;
    private int semester;
    private double GPA;
    private Integer deptRank;
    private Double targetGPA;
}
