package com.academetrics.controller;

import com.academetrics.dto.UserDTO;
import com.academetrics.entity.User;
import com.academetrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin // for better security
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addNewUser") // Map ONLY POST Requests
    public String addNewUser (@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "User Saved";
    }

    @GetMapping("/showAllUsers")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.getAllUsers();
    }


}
