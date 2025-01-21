package com.perfuma2.application.usecase;

import com.perfuma2.domain.entities.User;
import com.perfuma2.domain.services.UserService;
import com.perfuma2.infrastructure.persistence.UserRepository;
import com.perfuma2.interfaces.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public HttpStatus createUser(UserDTO dto) {
        try{
            User user = setPersistenceUser(dto);
            this.repository.save(user);
            return HttpStatus.CREATED;
        }catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

    private User setPersistenceUser(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public HttpStatus updateUser(UserDTO user) {
        return null;
    }

    @Override
    public HttpStatus deleteUser(UserDTO user) {
        return null;
    }

    @Override
    public String encodePassword(String pass) {
        return null;
    }
}
