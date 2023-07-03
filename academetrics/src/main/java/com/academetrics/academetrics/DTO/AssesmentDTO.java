package com.academetrics.academetrics.DTO;

import com.academetrics.academetrics.DTO.CourseOfferingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssesmentDTO {

    private Integer assesId; // eg: assesment id
    private String type; // eg: lab/project/mid/quiz/tutorial/assignment
    private Integer max_marks; // Out of Total( x% ) eg: 10
    private CourseOfferingDTO courseOfferingDTO; // regarding courseOffering eg: CO221-2023

}
