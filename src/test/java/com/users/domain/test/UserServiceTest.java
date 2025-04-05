package com.users.domain.test;

import com.users.application.dto.UserDTO;
import com.users.domain.models.Location;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    Location location = new Location();
    UserDTO user = new UserDTO();

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
