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

import java.util.*;

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
        studentProfileDTO.setTargetGPA(student.getTargetGpa());

        return studentProfileDTO;
    }

    private Student studentProfileDTOToEntity(StudentProfileDTO studentProfileDTO){
        Student student = new Student();
        student.setUserName(studentProfileDTO.getUserName());
        student.setSemester(studentProfileDTO.getSemester());
        student.setAcademicYear(studentProfileDTO.getAcademicYear());
        student.setGpa(studentProfileDTO.getGPA());
        student.setDeptRank(studentProfileDTO.getDeptRank());
        if (studentProfileDTO.getTargetGPA() != null){
            student.setTargetGpa(studentProfileDTO.getTargetGPA());
        }

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

    public List<StudentCourseDTO> getFollowingCourses(String userName) throws Exception{
        Student student = studentRepository.findById(userName).orElse(null);

        if (student == null)
            throw new Exception("Student not found");

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
                courseOfferingDTO.setCourse(courseDTO);
                courseOfferingDTO.setYear(studentCourse.getCourseOffering().getCourseOfferingId().getYear());
                StudentCourseDTO studentCourseDTO = new StudentCourseDTO();
                studentCourseDTO.setCourseOffering(courseOfferingDTO);
                studentCourseDTO.setGrade(studentCourse.getGrade());
                studentCourseDTOList.add(studentCourseDTO);
            }
        }
        return studentCourseDTOList;
    }

    public void updateTargetGpa(String userName, Double targetGpa){
        studentRepository.updateTargetGpa(userName, targetGpa);
    }

    public Map<String, String> getTargetResults (String userName) throws Exception{
        Map<String, Double> gpaOfGrade = new HashMap<>();
        gpaOfGrade.put("A+", 4.0);
        gpaOfGrade.put("A", 4.0);
        gpaOfGrade.put("A-", 3.7);
        gpaOfGrade.put("B+", 3.3);
        gpaOfGrade.put("B", 3.0);
        gpaOfGrade.put("B-", 2.7);
        gpaOfGrade.put("C+", 2.3);
        gpaOfGrade.put("C", 2.0);
        gpaOfGrade.put("C-", 1.7);
        gpaOfGrade.put("D+", 1.3);
        gpaOfGrade.put("D", 1.8);
        gpaOfGrade.put("E", 0.0);

        Map<String, String> targetResults = new HashMap<>();

        Student student = studentRepository.findById(userName).orElse(null);

        if (student == null)
            throw new Exception("Student not found");

        if (student.getTargetGpa() == null || student.getTargetGpa() < 0.0 || student.getTargetGpa() > 4.0 || student.getTargetGpa() < student.getGpa())
            throw new Exception("Student has invalid target gpa");

        // get current list of courses followed by the student and set target gpa to D;
        Map<Course, String> currentCourses = new HashMap<>();

        if(student.getFollowingCourses().isEmpty())
            throw new Exception("Student doesn't follow any courses");

        for (StudentCourse studentCourse : student.getFollowingCourses()){
            if (studentCourse.getGrade() == null){
                currentCourses.put(studentCourse.getCourseOffering().getCourseOfferingId().getCourse(), "D");
            }
        }

        // check if target gpa is possible
        double maxPossibleGpa = student.getGpa();
        double maxCiGi = 0.0;

        for (Course course : currentCourses.keySet()) {
            maxCiGi += course.getCredits() * 4.0;
        }

        maxPossibleGpa += maxCiGi / student.getTotalCredits();
        maxPossibleGpa = Math.round(maxPossibleGpa * 100.0) / 100.0;

        if (student.getTargetGpa() > maxPossibleGpa)
            throw new Exception("Achieving target GPA is impossible");



        // each grade will be advanced until the target gpa is achieved
        List<String> gradesInDescOrder = new ArrayList<>(Arrays.asList("D+", "C-", "C", "C+",
                "B-", "B", "B+", "A-", "A", "A+"));

        outerloop:
        for (String nextGrade : gradesInDescOrder){
            for (Course course : currentCourses.keySet()){
                currentCourses.put(course, nextGrade);
                double currGpa = student.getGpa();
                double currCiGi = 0.0;
                for (Course tempCourse : currentCourses.keySet()) {
                    currCiGi += tempCourse.getCredits() * gpaOfGrade.get(currentCourses.get(tempCourse));
                }
                currGpa += currCiGi / student.getTotalCredits();
                currGpa = Math.round(currGpa * 100.0) / 100.0;

                if (currGpa >= student.getTargetGpa())
                    break outerloop;
            }
        }

        for (Course course : currentCourses.keySet()){
            targetResults.put(course.getCode(), currentCourses.get(course));
        }
        return targetResults;
    }
}
