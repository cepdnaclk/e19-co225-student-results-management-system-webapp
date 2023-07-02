package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.UserDTO;
import com.academetrics.academetrics.DTO.UserRegistrationDTO;
import com.academetrics.academetrics.Entity.User;
import com.academetrics.academetrics.Service.UserService;
import jakarta.persistence.PersistenceException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    // Send details of all users if no id is specified in GET request
    @GetMapping("/")
    @PreAuthorize("hasAuthority('admin')")
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "/", params = {"userName"})
    public ResponseEntity<?> getUser(@RequestParam String userName){
        UserDTO userDTO = userService.getUser(userName);
        if (userDTO == null){
            return ResponseEntity.status(404).body("User not found");
        }
        else{
            return ResponseEntity.status(200).body(userDTO);
        }
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "Welcome User";
    }

    @PostMapping(value="/", consumes = {"application/json"})
    public ResponseEntity<?> saveUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        // check if user all ready exists
        if (getUser(userRegistrationDTO.getUserName()) == null){
            try{
                userService.saveUser(userRegistrationDTO);
                return ResponseEntity.status(200).body("Saved");
            }catch (Exception e) {
                return ResponseEntity.status(400).body("Save failed: " + e.getMessage());
            }
        }else {
            return ResponseEntity.status(409).body("User already exists");
        }
    }
    @PutMapping("/")
    public String updateUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        // Update uses the same repo functionality as save
        userService.saveUser(userRegistrationDTO);
        return "Updated";
    }
    @DeleteMapping("/")
    public boolean deleteUser(@RequestParam String userName){
        return userService.deleteUser(userName);
    }

//    @GetMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestParam String userName, @RequestParam String password){
//        UserRegistrationDTO user =  userService.getUserFromUserName(userName);
//
//        if (user == null){
//            return ResponseEntity.status(404).body("User doesn't exist");
//        }else if (password.equals(user.getPassword())){
////            return ResponseEntity.status(200).body("Successful");
//            // TODO: return UserDTO
//            return ResponseEntity.status(200).body(user);
//        }else {
//            return ResponseEntity.status(401).body("Invalid password");
//        }
//    }


}
