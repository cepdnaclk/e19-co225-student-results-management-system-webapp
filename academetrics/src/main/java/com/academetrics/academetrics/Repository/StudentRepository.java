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

    @Modifying
    @Transactional
    @Query(value = "UPDATE student SET target_gpa=?2 WHERE user_name = ?1", nativeQuery = true)
    void updateTargetGpa(String userName, double targetGpa);

    @Query(value = "SELECT " +
            "row_number() OVER () AS 'rank' " +
            "FROM " +
            "(SELECT u.user_name " +
            "FROM student as s " +
            "INNER JOIN user as u " +
            "ON (s.user_name = u.user_name) " +
            "AND u.dept_id = ?1 " +
            "AND s.academic_year = ?2 " +
            "AND s.semester = ?3 " +
            "ORDER BY s.gpa) as t " +
            "WHERE " +
            "t.user_name = ?4 " +
            ";", nativeQuery = true)
    Integer getDeptRank(String department, Integer academicYear, Integer semester, String userName);
}
