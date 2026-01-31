package com.stgsporting.honakyakon5ademi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class KhedmaNotFound extends NotFoundException {
    public KhedmaNotFound(String message) {
        super(message);
    }

    public KhedmaNotFound() {
        super("Osra not found");
    }
}
