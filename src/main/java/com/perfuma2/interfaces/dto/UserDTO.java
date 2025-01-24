package com.perfuma2.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.perfuma2.domain.entities.Location;
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
