package com.mikhail.golovackii.pet_shelter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Information: such a file exists")
public class FileExistsException extends RuntimeException {
    public FileExistsException() {
    }
}
