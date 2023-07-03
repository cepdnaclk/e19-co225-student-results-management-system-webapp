package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.*;
import com.academetrics.academetrics.Entity.Student;
import com.academetrics.academetrics.Entity.StudentCourse;
import com.academetrics.academetrics.Entity.User;
import com.academetrics.academetrics.Repository.CourseOfferingRepository;
import com.academetrics.academetrics.Repository.CourseRepository;
import com.academetrics.academetrics.Repository.StudentRepository;
import com.academetrics.academetrics.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academetrics.academetrics.Entity.CourseOfferingId;
import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Entity.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseOfferingRepository courseOfferingRepository;
    @Autowired
    private CourseRepository courseRepository;

    public StudentProfileDTO getStudentDetails(String userName){
        Student student = studentRepository.findById(userName).orElse(null);
        return studentEntityToProfileDTO(student);
    }

//    public Double getGPA(String userName){
//        Map<String, Double> gpaOfGrade = new HashMap<>();
//        gpaOfGrade.put("A+", 4.0);
//        gpaOfGrade.put("A", 4.0);
//        gpaOfGrade.put("A-", 3.7);
//        gpaOfGrade.put("B+", 3.3);
//        gpaOfGrade.put("B", 3.0);
//        gpaOfGrade.put("B-", 2.7);
//        gpaOfGrade.put("C+", 2.3);
//        gpaOfGrade.put("C", 2.0);
//        gpaOfGrade.put("C-", 1.7);
//        gpaOfGrade.put("D+", 1.3);
//        gpaOfGrade.put("D", 1.8);
//        gpaOfGrade.put("E", 0.0);
//
//
//        double gpa = 0.0;
//        double sumCiGi = 0.0;
//        double sumCi = 0.0;
//        Student student = studentRepository.findById(userName).orElse(null);
//
//        if (student == null)
//            return null;
//
//        for (StudentCourse studentCourse : student.getFollowingCourses()){
//            String currGrade = studentCourse.getGrade();
//
//            if (currGrade != null){
//                sumCiGi += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits() * gpaOfGrade.get(currGrade);
//                sumCi += studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCredits();
//            }
//        }
//        gpa = sumCiGi / sumCi;
//        return gpa;
//    }

    private StudentProfileDTO studentEntityToProfileDTO(Student student){
        if (student == null) return null;

        StudentProfileDTO studentProfileDTO = new StudentProfileDTO();
        studentProfileDTO.setUserName(student.getUserName());
        studentProfileDTO.setSemester(student.getSemester());
        studentProfileDTO.setAcademicYear(student.getAcademicYear());
        studentProfileDTO.setGPA(student.getGpa());
        studentProfileDTO.setDeptRank(student.getDeptRank());

        return studentProfileDTO;
    }

    private Student studentProfileDTOToEntity(StudentProfileDTO studentProfileDTO){
        Student student = new Student();
        student.setUserName(studentProfileDTO.getUserName());
        student.setSemester(studentProfileDTO.getSemester());
        student.setAcademicYear(studentProfileDTO.getAcademicYear());
        student.setGpa(studentProfileDTO.getGPA());
        student.setDeptRank(studentProfileDTO.getDeptRank());

        return student;
    }

    public void saveStudent(StudentProfileDTO studentProfileDTO) {
        studentRepository.save(studentProfileDTOToEntity(studentProfileDTO));
    }

    public void updateSemester(String userName, int academicYear, int semester){
        studentRepository.updateStudentSemester(userName, academicYear, semester);
    }

    public void assignCourseToStudent(String userName, String courseCode, int year){
        // get student entity
        Student student = studentRepository.findById(userName).orElse(null);

        // TODO: better error handling
        if (student == null)
            return;

        // get course offering entity
        Course course = courseRepository.findById(courseCode).orElse(null);

        // TODO: better error handling
        if (course == null)
            return;

        CourseOfferingId courseOfferingID =  new CourseOfferingId();
        courseOfferingID.setCourse(course);
        courseOfferingID.setYear(year);

        CourseOffering courseOffering = courseOfferingRepository.findById(courseOfferingID).orElse(null);

        // TODO: better error handling
        if (courseOffering == null)
            return;

        student.addCourse(courseOffering);

        studentRepository.save(student);
    }

    public List<StudentCourseDTO> getFollowingCourses(String userName){
        Student student = studentRepository.findById(userName).orElse(null);

        if (student == null)
            return null;

        List<StudentCourseDTO> studentCourseDTOList = new ArrayList<>();
        if (!student.getFollowingCourses().isEmpty()){
            for (StudentCourse studentCourse : student.getFollowingCourses()) {
                Course course = courseRepository.findById(studentCourse.getCourseOffering().getCourseOfferingId().getCourse().getCode()).orElse(null);
                if (course == null) continue;
                CourseDTO courseDTO = new CourseDTO();
                courseDTO.setCode(course.getCode());
                courseDTO.setName(course.getName());
                courseDTO.setCredits(course.getCredits());
                CourseOfferingDTO courseOfferingDTO = new CourseOfferingDTO();
                courseOfferingDTO.setCourseDTO(courseDTO);
                courseOfferingDTO.setYear(studentCourse.getCourseOffering().getCourseOfferingId().getYear());
                StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
                studentCourseDTO.setCourseOffering(courseOfferingDTO);
                studentCourseDTO.setGrade(studentCourse.getGrade());
                studentCourseDTOList.add(studentCourseDTO);
            }
        }
        return studentCourseDTOList;
    }
}
