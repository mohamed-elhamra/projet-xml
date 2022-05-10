package fr.univrouen.rss22project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> othersExceptionHandler(RuntimeException ex, WebRequest rq) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(buildException(ex));
    }

    private ErrorMessage buildException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setTimestamp(new Date());
        errorMessage.setException(ex.getClass().getName());
        errorMessage.setMessage(ex.getMessage());
        if (ex.getCause() != null) {
            errorMessage.setCause(ex.getCause().getMessage());
        }
        return errorMessage;
    }
}