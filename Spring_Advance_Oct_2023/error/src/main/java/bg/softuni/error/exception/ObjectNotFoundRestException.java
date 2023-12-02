package bg.softuni.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ObjectNotFoundRestException extends RuntimeException{
    public ObjectNotFoundRestException(String message) {
        super(message);
    }
}
