package com.shehnaz.SwaggerAPI_App.advice;

import com.shehnaz.SwaggerAPI_App.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristErrorController {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFoundException(TouristNotFoundException ex){
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setStatusCode(404);
        errorDetails.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex){
        ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setMessage("Some Problem Occured");
        errorDetails.setStatusCode(404);
        errorDetails.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }

}
