package project_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvance {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<MensajeDto> runtimeException(RuntimeException e) {
        MensajeDto error = MensajeDto.builder().messageCode("500").message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<MensajeDto> badRequestException(BadRequestException e) {
        MensajeDto error = MensajeDto.builder().messageCode("400").message(e.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<MensajeDto> requestException(RequestException e) {
        MensajeDto error = MensajeDto.builder().messageCode("207").message(e.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.MULTI_STATUS);
    }
}
