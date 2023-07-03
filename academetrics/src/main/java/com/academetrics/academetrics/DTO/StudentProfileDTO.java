package com.academetrics.academetrics.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentProfileDTO {
    private String userName;
    private int academicYear;
    private int semester;
    private double GPA;
    private Integer deptRank;
    private Double targetGPA;
}
