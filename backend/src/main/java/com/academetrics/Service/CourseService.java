package com.academetrics.academetrics.Service;

import com.academetrics.dto.CourseDTO;
import com.academetrics.entity.Course;
import com.academetrics.repo.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepository.save(course);
        return courseDTO;
    }

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }


}
