package com.hostbooks.SchoolManagementSystemAPI.Exception;

import io.jsonwebtoken.MalformedJwtException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentException.class)
    public ResponseEntity<ErrorDetails> studentExceptionHandler(StudentException e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseException.class)
    public ResponseEntity<ErrorDetails> courseExceptionHandler(CourseException e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException manv, WebRequest wr, Errors result){
//        String message = manv.getBindingResult().getFieldError().getDefaultMessage();
//        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), message, wr.getDescription(false));
//        return new ResponseEntity<>(ResponseDTO.getResponseObj(null,LocalDateTime.now(),"Invalid Constraint", HttpStatus.BAD_REQUEST, ErrorResponse.getErrorResponse(result)), HttpStatus.FORBIDDEN);
//    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDetails> noSuchElementExceptionHandler(NoSuchElementException e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDetails> noResultFoundExceptionHandler(EmptyResultDataAccessException e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<ErrorDetails> jwtExceptionHandler(MalformedJwtException e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> exceptionHandler(Exception e, WebRequest wr){
        ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
        return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
}
