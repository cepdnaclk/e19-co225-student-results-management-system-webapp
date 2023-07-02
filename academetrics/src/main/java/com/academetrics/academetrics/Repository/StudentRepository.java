package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.Entity.Student;
import com.academetrics.academetrics.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

//    @Query(value = "SELECT * FROM user u WHERE u.user_name = ?1", nativeQuery = true)
//    List<User> getUserFromUserName(String userName);
}
