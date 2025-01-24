package com.perfuma2.domain.services;

import com.perfuma2.domain.exception.DomainException;
import com.perfuma2.interfaces.dto.UserDTO;
import com.perfuma2.interfaces.rest.RestResponse;
import org.springframework.http.HttpStatus;

public interface UserService {
    public HttpStatus createUser(UserDTO user);
    public RestResponse updateUser(UserDTO user) throws DomainException;
    public HttpStatus deleteUser(UserDTO user);
    public String encodePassword(String pass);
}
