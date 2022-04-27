package com.mikhail.golovackii.pet_shelter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Information: need upload photo")
public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }
}
