package com.academetrics.academetrics.Service;

import com.academetrics.academetrics.DTO.CourseOfferingDTO;
import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Entity.CourseOfferingId;
import com.academetrics.academetrics.Repository.CourseOfferingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseOfferingService {

    private final CourseOfferingRepository courseOfferingRepository;

    @Autowired
    public CourseOfferingService(CourseOfferingRepository courseOfferingRepository) {
        this.courseOfferingRepository = courseOfferingRepository;
    }

    public CourseOfferingDTO saveCourseOffering(CourseOfferingDTO courseOfferingDTO) {
        CourseOffering courseOffering = new CourseOffering();
        courseOffering.setCode(courseOfferingDTO.getCode());
        courseOffering.setYear(courseOfferingDTO.getYear());

        courseOfferingRepository.save(courseOffering);
        return courseOfferingDTO;
    }


    public Iterable<CourseOffering> getAllCourseOfferings() {
        return courseOfferingRepository.findAll();
    }

    public CourseOfferingDTO updateCourseOffering(String courseCode, CourseOfferingDTO updatedCourseOfferingDTO) {
        CourseOffering existingCourseOffering = courseOfferingRepository.findByCode(courseCode);

        if (existingCourseOffering != null) {
            existingCourseOffering.setYear(updatedCourseOfferingDTO.getYear());

            courseOfferingRepository.save(existingCourseOffering); // save in the course repo
        }
        else {
         // handling the case where course Offering is not found (courseCode == null)
            throw new RuntimeException("Course Offering not found with code: " + courseCode);
        }
        return updatedCourseOfferingDTO;
    }
    public void deleteCourseOffering(CourseOfferingId courseOfferingId) {
        courseOfferingRepository.deleteByCodeAndYear(courseOfferingId);
    }

}
