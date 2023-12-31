package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register (@Valid @RequestBody UserDTO userDTO){
        userDTO = userService.register(userDTO);
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(userDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login (@Valid @RequestBody UserDTO userDTO){
        userDTO = userService.login(userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
