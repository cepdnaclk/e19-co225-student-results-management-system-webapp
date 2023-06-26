package com.academetrics.academetrics.Controller;

import com.academetrics.academetrics.DTO.UserDTO;
import com.academetrics.academetrics.DTO.UserRegistrationDTO;
import com.academetrics.academetrics.Entity.User;
import com.academetrics.academetrics.Service.UserService;
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
    @GetMapping(value = "/", params = {"id"})
    public UserDTO getUser(@RequestParam int id){
        return userService.getUser(id);
    }

    @GetMapping(value = "/welcome")
    public String welcome(){
        return "Welcome User";
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
    public boolean deleteUser(@RequestParam int id){
        return userService.deleteUser(id);
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
