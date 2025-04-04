package com.users.interfaces.rest;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class RestObjectResponse<T> extends RestResponse{
    private T objectResponse;

    public RestObjectResponse(HttpStatus statusCode, String message) {
        super(statusCode, message);
    }

}
