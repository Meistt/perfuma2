package com.perfuma2.application.usecase;

import com.perfuma2.domain.entities.Location;
import com.perfuma2.domain.entities.User;
import com.perfuma2.domain.exception.DomainException;
import com.perfuma2.domain.services.UserService;
import com.perfuma2.infrastructure.persistence.UserRepository;
import com.perfuma2.interfaces.dto.UserDTO;
import com.perfuma2.interfaces.rest.RestObjectResponse;
import com.perfuma2.interfaces.rest.RestResponse;
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
        user.setLocation(dto.getLocation());
        Location location = dto.getLocation();
        location.setUser(user);
        return user;
    }

    @Override
    public RestResponse updateUser(UserDTO dto) throws DomainException {
        User user = this.getUserByEmail(dto.getEmail());
        if ( user == null ){
            return new RestResponse(HttpStatus.NOT_FOUND, "User " + dto.getEmail() + " not exist.");
        }
        setUserInformation(user, dto);
        return new RestObjectResponse(HttpStatus.OK, "User "+ dto.getEmail() + " updated successfully");
    }

    private void setUserInformation(User user, UserDTO dto ) throws DomainException {
        try{
            Location location = user.getLocation();
            user.setUserName((dto.getUserName() != null || user.getUserName() != dto.getUserName()) ? dto.getUserName() : user.getName());
            user.setName((dto.getName() != null || user.getName() != dto.getName()) ? dto.getName() : user.getName());
            user.setLastName((dto.getLastName() != null || user.getLastName() != dto.getLastName()) ? dto.getLastName() : user.getLastName());
            user.setLocation((dto.getLocation().equals(location)) ? dto.getLocation() : user.getLocation());
        } catch (Exception e){
            //TODO: change exception error message
            throw new DomainException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred during updating user.");
        }
    }

    private User getUserByEmail(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public RestResponse deleteUser(String email) throws DomainException {
        User user = this.getUserByEmail(email);
        if (user == null){
            throw new DomainException(HttpStatus.NOT_FOUND, "User " + email + " Not found.");
        }
        this.repository.delete(user);
        return new RestResponse(HttpStatus.OK, "User deleted succefully.");
    }

    @Override
    public String encodePassword(String pass) {
        return null;
    }
}
