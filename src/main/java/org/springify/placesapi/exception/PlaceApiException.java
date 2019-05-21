package org.springify.placesapi.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class PlaceApiException extends RuntimeException {
    public PlaceApiException(String errorMessage) {
        super(errorMessage);
    }
}
