package project_management.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestException extends RuntimeException {

    private String messageCode;

    public RequestException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }
}
