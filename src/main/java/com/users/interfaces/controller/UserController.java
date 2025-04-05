package com.users.interfaces.controller;

import com.users.domain.exception.DomainException;
import com.users.domain.services.UserService;
import com.users.application.dto.UserDTO;
import com.users.interfaces.rest.RestResponse;
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

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user){
        HttpStatus code = this.service.createUser(user);
        return new ResponseEntity<>("Usuario creado con éxito", code);
    }

    @PutMapping
    public ResponseEntity<RestResponse> updateUser(@RequestBody UserDTO user) throws DomainException {
        RestResponse response = this.service.updateUser(user);
        return new ResponseEntity<>(response, response.getStatusCode());

    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<RestResponse> deleteUser(String email) throws DomainException {
        RestResponse response = this.service.deleteUser(email);

        return null;
    }
}
