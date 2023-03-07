package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException{

    @Serial
    private static final long serialVersionUID=1L;

    public RequiredObjectIsNullException(){
        super("Não Permitido add objetos nulos!");
    }

    public RequiredObjectIsNullException(String ex){
        super(ex);
    }

}
