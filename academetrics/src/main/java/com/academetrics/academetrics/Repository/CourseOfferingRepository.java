package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.CourseOffering;
import com.academetrics.academetrics.Entity.CourseOfferingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, CourseOfferingId> {
//    CourseOffering findByCourseOfferingId(CourseOfferingId courseOfferingId);

//    void deleteByCodeAndYear(CourseOfferingId courseOfferingId);
}

