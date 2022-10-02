package com.hostbooks.SchoolManagementSystemAPI.Controller;

import com.hostbooks.SchoolManagementSystemAPI.Security.JwtAuthResponse;
import com.hostbooks.SchoolManagementSystemAPI.Service.UserService;
import com.hostbooks.SchoolManagementSystemAPI.models.LoginDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.ResponseDTO;
import com.hostbooks.SchoolManagementSystemAPI.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
public class SignUpLoginController {

    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public ResponseEntity<?> loginController(@RequestBody LoginDTO loginDTO){

        JwtAuthResponse jwtAuthResponse= userService.login(loginDTO);

        return new ResponseEntity<>(ResponseDTO.getResponseObj(jwtAuthResponse, LocalDateTime.now(), HttpStatus.OK,HttpStatus.OK.value(), null),HttpStatus.ACCEPTED);

    }

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpController(@RequestBody UserDTO userDTO){
        UserDTO registeredUser= userService.addRoles(userDTO);
        return new ResponseEntity<>(ResponseDTO.getResponseObj(registeredUser,LocalDateTime.now(),HttpStatus.OK,HttpStatus.OK.value(), null),HttpStatus.ACCEPTED);
    }





}
