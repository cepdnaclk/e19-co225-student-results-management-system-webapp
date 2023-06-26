package com.academetrics.academetrics.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

    @GetMapping("/login")
    public String loginUser(){return "Yee! you are logged in";}

    @PostMapping("/login")
    public String checklogin(){
        return "loginCheck";
    }

//    @GetMapping("/loggingError")
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
