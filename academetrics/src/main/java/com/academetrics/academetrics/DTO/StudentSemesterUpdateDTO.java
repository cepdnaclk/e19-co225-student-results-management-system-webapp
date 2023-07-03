package com.academetrics.academetrics.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentSemesterUpdateDTO {
    int semester;
    int academicYear;

    List<String> userNames;
}
