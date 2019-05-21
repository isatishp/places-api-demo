package org.springify.placesapi.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class PlaceNotFoundException extends RuntimeException {

    public PlaceNotFoundException(String message) {
        super(message);
    }
}
