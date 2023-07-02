package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.Student;
import com.academetrics.academetrics.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, String> {

//    @Query(value = "SELECT * FROM user u WHERE u.user_name = ?1", nativeQuery = true)
//    List<User> getUserFromUserName(String userName);
//

    // Update the semester and academic year of a student
    @Modifying
    @Transactional
    @Query(value = "UPDATE student SET academic_year=?2, semester=?3 WHERE user_name = ?1", nativeQuery = true)
    void updateStudentSemester(String userName, int academicYear, int semester);
}
