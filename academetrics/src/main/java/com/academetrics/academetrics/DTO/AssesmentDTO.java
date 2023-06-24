package com.academetrics.academetrics.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssesmentDTO {

    private String id; // eg: assesment id
    private String type; // eg: lab/project/mid/quiz/tutorial/assignment
    private Integer max_marks; // Out of Total( x% ) eg: 10

}
