package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.UserDTO;
import com.academetrics.academetrics.DTO.UserRegistrationDTO;
import com.academetrics.academetrics.Entity.User;
import com.academetrics.academetrics.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<UserDTO> getUser() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "/", params = {"userName"})
    public UserDTO getUser(@RequestParam String userName){
        return userService.getUser(userName);
    }
    @PostMapping(value="/", consumes = {"application/json"})
    public String saveUser(@RequestBody UserRegistrationDTO userRegistrationDTO){
        userService.saveUser(userRegistrationDTO);
        return "Saved";
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

    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String userName, @RequestParam String password){
        UserRegistrationDTO user =  userService.getUserRegistration(userName);

        if (user == null){
            return ResponseEntity.status(404).body("User doesn't exist");
        }else if (password.equals(user.getPassword())){
//            return ResponseEntity.status(200).body("Successful");
            // TODO: return UserDTO
            return ResponseEntity.status(200).body(user);
        }else {
            return ResponseEntity.status(401).body("Invalid password");
        }
    }
}
