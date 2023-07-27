package com.academetrics.academetrics;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.academetrics.academetrics.DTO.StudentProfileDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.modelmapper.ModelMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getExistingStudent() throws Exception {
        String userName = "E/19/275";
        this.mockMvc.perform(get("/student/").param("userName", userName))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingStudent() throws Exception {
        String userName = "E/01/001";
        this.mockMvc.perform(get("/student/").param("userName", userName))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("Student not found")));
    }

    @Test
    public void addValidStudent() throws Exception{
        String body = "{\n" +
                "    \"userName\": \"E/19/002\",\n" +
                "    \"academicYear\": 2,\n" +
                "    \"semester\": 4,\n" +
                "    \"deptRank\": 1,\n" +
                "    \"targetGPA\": null,\n" +
                "    \"gpa\": 3.0\n" +
                "}";

        this.mockMvc.perform(post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Saved")))
        ;
    }

    @Test
    public void addExistingStudent() throws Exception{
        String body = "{\n" +
                "    \"userName\": \"E/10/001\",\n" +
                "    \"academicYear\": 2,\n" +
                "    \"semester\": 4,\n" +
                "    \"deptRank\": 1,\n" +
                "    \"targetGPA\": null,\n" +
                "    \"gpa\": 2.57\n" +
                "}";

        this.mockMvc.perform(post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(content().string(containsString("User already exists")))
        ;
    }

    @Test
    public void updateStudentSemester() throws Exception {
        String body = "{" +
                "    \"academicYear\": \"2024\",\n" +
                "    \"semester\": \"4\",\n" +
                "    \"userNames\": [\"E/10/001\", \"E/19/275\"] \n" +
                "}";

        this.mockMvc.perform(put("/student/update-semester")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Update Successfully")))
        ;
    }

    @Test
    public void updateStudentCourses() throws Exception {
        String body = "{\n" +
                "    \"courseCode\" : \"GP106\",\n" +
                "    \"year\": \"2023\",\n" +
                "    \"userNames\": [\"E/19/275\"] \n" +
                "}";

        this.mockMvc.perform(put("/student/course-assignment")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Update Successfully")))
        ;
    }

    @Test
    public void updateTargetGPAAndGetResults() throws Exception{
        this.mockMvc.perform(put("/student/target-gpa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("userName", "E/10/001")
                        .param("targetGPA", "3.8")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Target GPA updated")))
        ;

        this.mockMvc.perform(get("/student/target-results")
                        .param("userName", "E/10/001")
                )
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void getTargetResultsWithInvalidGPA() throws Exception{
        this.mockMvc.perform(get("/student/target-results")
                        .param("userName", "E/10/001")
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }
}
