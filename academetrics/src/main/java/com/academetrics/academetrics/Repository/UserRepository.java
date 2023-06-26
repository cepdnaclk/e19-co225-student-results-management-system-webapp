package com.academetrics.academetrics.Repository;

import com.academetrics.academetrics.DTO.UserRegistrationDTO;
import com.academetrics.academetrics.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM user u WHERE u.user_name = ?1", nativeQuery = true)
    List<User> getUserFromUserName(String userName);


    Optional<User> findByUserName(String username);
}
