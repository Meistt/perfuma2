package com.perfuma2.domain.services;

import com.perfuma2.interfaces.dto.UserDTO;
import org.springframework.http.HttpStatus;

public interface UserService {
    public HttpStatus createUser(UserDTO user);
    public HttpStatus updateUser(UserDTO user);
    public HttpStatus deleteUser(UserDTO user);
    public String encodePassword(String pass);
}
