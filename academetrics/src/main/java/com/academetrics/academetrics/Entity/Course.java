package com.academetrics.academetrics.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
    @Id
    private String code; // eg: GP106
    private String name; // eg: Computing
    private Integer credits; // eg: 3
}
