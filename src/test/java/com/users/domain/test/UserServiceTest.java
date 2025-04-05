package com.users.domain.test;

import com.users.application.dto.UserDTO;
import com.users.domain.models.Location;
import com.users.domain.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


public class UserServiceTest {
    Location location = new Location();
    UserDTO user = new UserDTO();

    @InjectMocks
    UserService service;

    @Test
    public void createUserWithoutError(){
        givenUserIsNotRegisteredInDatabase();
        whenUserIsRegistered();
        thenUserIsSavedInDatabase();
    }
    private void givenUserIsNotRegisteredInDatabase() {

    }

    private void whenUserIsRegistered() {


    }

    private void thenUserIsSavedInDatabase() {
    }
}
