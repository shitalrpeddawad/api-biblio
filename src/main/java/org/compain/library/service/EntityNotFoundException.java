package org.compain.library.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    private final static String MESSAGE = "Entity %s NOT FOUND with id %s";
    public EntityNotFoundException(Class<?> clazz, Long id){
        super(String.format(MESSAGE, clazz.getSimpleName(), id));
    }
}

