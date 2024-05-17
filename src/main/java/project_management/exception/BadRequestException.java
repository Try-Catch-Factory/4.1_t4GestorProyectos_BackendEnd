package project_management.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException {

    private String messageCode;

    public BadRequestException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
    }
}
