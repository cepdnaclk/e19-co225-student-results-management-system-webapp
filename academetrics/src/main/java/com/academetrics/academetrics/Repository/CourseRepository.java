package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    Course findByCode(String courseCode);
    void deleteByCode(String courseCode);


}
