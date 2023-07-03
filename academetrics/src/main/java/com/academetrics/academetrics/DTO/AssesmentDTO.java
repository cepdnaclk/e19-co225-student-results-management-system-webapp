package com.academetrics.academetrics.DTO;

import com.academetrics.academetrics.Entity.CourseOffering;
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
    private CourseOffering courseOffering;

}
