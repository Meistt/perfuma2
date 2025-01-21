package com.perfuma2.interfaces.controller;

import com.perfuma2.domain.services.UserService;
import com.perfuma2.interfaces.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/get-list")
    public String getUsersList(){
        return "HOLA LLEGUÉ";
    }

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user){
        HttpStatus code = this.service.createUser(user);
        return new ResponseEntity<>("Operación exitosa", code);
    }
}
