package com.users.domain.services;

import com.users.domain.exception.DomainException;
import com.users.interfaces.dto.UserDTO;
import com.users.interfaces.rest.RestResponse;
import org.springframework.http.HttpStatus;

public interface UserService {
    public HttpStatus createUser(UserDTO user);
    public RestResponse updateUser(UserDTO user) throws DomainException;
    public RestResponse deleteUser(String email) throws DomainException;
    public String encodePassword(String pass);
}
