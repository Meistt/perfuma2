package com.users.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.users.domain.models.Location;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("lastName")
    private String lastName;

    @NotNull
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("userName")
    private String userName;

    @NotNull
    @JsonProperty("password")
    private String password;

    @NotNull
    @JsonProperty("location")
    private Location location;

}
