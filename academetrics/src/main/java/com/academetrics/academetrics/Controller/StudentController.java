package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.StudentProfileDTO;
import com.academetrics.academetrics.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/", params = {"userName"})
    public ResponseEntity<?> getStudent(@RequestParam String userName){
        StudentProfileDTO studentProfileDTO = studentService.getStudentDetails(userName);
        if (studentProfileDTO == null){
            return ResponseEntity.status(404).body("Student not found");
        }
        else{
            return ResponseEntity.status(200).body(studentProfileDTO);
        }
    }

    @PostMapping(value="/", consumes = {"application/json"})
    public ResponseEntity<?> saveStudent(@RequestBody StudentProfileDTO studentProfileDTO){
        // check if student already exists
        if (studentService.getStudentDetails(studentProfileDTO.getUserName()) == null){
            try{
                studentService.saveStudent(studentProfileDTO);
                return ResponseEntity.status(200).body("Saved");
            }catch (Exception e) {
                return ResponseEntity.status(400).body("Save failed: " + e.getMessage());
            }
        }else {
            return ResponseEntity.status(409).body("User already exists");
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updateStudent(@RequestBody StudentProfileDTO studentProfileDTO){
        try{
            studentService.saveStudent(studentProfileDTO);
            return ResponseEntity.status(200).body("Updated");
        }catch (Exception e) {
            return ResponseEntity.status(400).body("Update failed: " + e.getMessage());
        }
    }

    // Students are not allowed to be removed, only users
}
