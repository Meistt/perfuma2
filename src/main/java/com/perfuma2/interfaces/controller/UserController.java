package com.perfuma2.interfaces.controller;

import com.perfuma2.domain.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/get-list")
    public String getUsersList(){
        return "HOLA LLEGUÉ";
    }
}
