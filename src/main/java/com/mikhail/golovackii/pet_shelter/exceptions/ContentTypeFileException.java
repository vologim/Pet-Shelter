package com.mikhail.golovackii.pet_shelter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE, reason = "Information: need jpg/jpeg file")
public class ContentTypeFileException extends RuntimeException {
    public ContentTypeFileException() {
    }
}
