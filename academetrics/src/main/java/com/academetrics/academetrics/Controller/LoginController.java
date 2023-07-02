package com.academetrics.academetrics.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class LoginController {

    // this is used for test security / login
    @GetMapping("login")
    public String loginUser(){return "<html \">\n" +
            "  <head th:include=\"layout :: head(title=~{::title},links=~{})\">\n" +
            "    <title>Please Login</title>\n" +
            "  </head>\n" +
            "  <body th:include=\"layout :: body\" th:with=\"content=~{::content}\">\n" +
            "    <div th:fragment=\"content\">\n" +
            "        <form name=\"f\" th:action=\"@{/login}\" method=\"post\">               \n" +
            "            <fieldset>\n" +
            "                <legend>Please Login</legend>\n" +
            "                <div th:if=\"${param.error}\" class=\"alert alert-error\">    \n" +
            "                    Invalid username and password.\n" +
            "                </div>\n" +
            "                <div th:if=\"${param.logout}\" class=\"alert alert-success\"> \n" +
            "                    You have been logged out.\n" +
            "                </div>\n" +
            "                <label for=\"username\">Username</label>\n" +
            "                <input type=\"text\" id=\"username\" name=\"username\"/>        \n" +
            "                <label for=\"password\">Password</label>\n" +
            "                <input type=\"password\" id=\"password\" name=\"password\"/>    \n" +
            "                <div class=\"form-actions\">\n" +
            "                    <button type=\"submit\" class=\"btn\">Log in</button>\n" +
            "                </div>\n" +
            "            </fieldset>\n" +
            "        </form>\n" +
            "    </div>\n" +
            "  </body>\n" +
            "</html>";}

    @PostMapping("login")
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

    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    @GetMapping("logout")
    public String performLogout(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        // .. perform logout
        this.logoutHandler.logout(request, response, authentication);
        return "logout successful";
    }
}
