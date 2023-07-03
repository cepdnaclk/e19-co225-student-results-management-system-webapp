package com.academetrics.academetrics.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentCourseAssignmentDTO {
    private String courseCode;
    private int year;

    List<String> userNames;
}
