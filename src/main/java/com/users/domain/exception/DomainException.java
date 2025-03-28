package com.users.domain.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class DomainException extends Exception{
    private HttpStatus status;

    public DomainException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
}
