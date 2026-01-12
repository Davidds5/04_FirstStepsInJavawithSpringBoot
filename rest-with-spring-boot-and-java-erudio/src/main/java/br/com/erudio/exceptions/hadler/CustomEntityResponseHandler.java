package br.com.erudio.exceptions.hadler;


import br.com.erudio.exceptions.ExceptionsResponse;
import br.com.erudio.exceptions.UnsurpportedMathOperationsExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    private final ResponseEntity<ExceptionsResponse> handlerAllExceptions(Exception ex, WebRequest request){
        ExceptionsResponse response = new ExceptionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }  @ExceptionHandler(UnsurpportedMathOperationsExceptions.class)
    private final ResponseEntity<ExceptionsResponse> handlerBadRequestExceptions(Exception ex, WebRequest request){
        ExceptionsResponse response = new ExceptionsResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
