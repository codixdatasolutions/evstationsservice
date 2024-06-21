package com.ecosystem.evstationsservice.customexception;



import com.ecosystem.evstationsservice.dto.response.ResponseDto;
import com.ecosystem.evstationsservice.enums.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenHandleException.class)
    public ResponseEntity<Object> handleForbiddenHandleException(ForbiddenHandleException ex) {
        log.info("Entry:: RestResponseEntityExceptionHandler.java ::: handleForbiddenHandleException() ::: Request Body-> ForibiddenException: {}", ex.getMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setPayload(new ArrayList<>());
        responseDto.setSuccess(Status.FAILURE);
        responseDto.setStatusMessage(ex.getMessage());
        log.info("Exit:: RestResponseEntityExceptionHandler.java ::: handleForbiddenHandleException() ::: Request Body-> ResponseDto: {}", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<Object> handleInvalidArgumentException(InvalidArgumentException ex) {
        log.info("Entry:: RestResponseEntityExceptionHandler.java ::: handleInvalidArgumentException() ::: Request Body-> InvalidArgumentException: {}", ex.getMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setPayload(new ArrayList<>());
        responseDto.setSuccess(Status.FAILURE);
        responseDto.setStatusMessage(ex.getMessage());
        log.info("Exit:: RestResponseEntityExceptionHandler.java ::: handleInvalidArgumentException() ::: Request Body-> ResponseDto: {}", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //This exception is called when Data not found
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        log.info("Entry:: RestResponseEntityExceptionHandler.java ::: handleNotFoundException() ::: Request Body-> DATA_NOT_FOUND : {}", ex.getMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setPayload(new ArrayList<>());
        responseDto.setSuccess(Status.FAILURE);
        responseDto.setStatusMessage(ex.getMessage());
        log.info("Exit:: RestResponseEntityExceptionHandler.java ::: handleNotFoundException() ::: Request Body-> ResponseDto: {}", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    //This exception is thrown when the user already Exists or any data is duplicated
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Object> handleConflictException(ConflictException ex) {
        log.info("Entry:: RestResponseEntityExceptionHandler.java ::: handleConflictException() ::: Request Body-> CONFLICT_DATA: {}", ex.getMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setPayload(new ArrayList<>());
        responseDto.setSuccess(Status.FAILURE);
        responseDto.setStatusMessage(ex.getMessage());
        log.info("Exit:: RestResponseEntityExceptionHandler.java ::: handleConflictException() ::: Request Body-> ResponseDto: {}", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        log.info("Entry:: RestResponseEntityExceptionHandler.java ::: handleException() ::: Request Body-> Exception: {}", ex.getMessage());
        ResponseDto responseDto = new ResponseDto();
        responseDto.setPayload(new ArrayList<>());
        responseDto.setSuccess(Status.FAILURE);
        responseDto.setStatusMessage(ex.getMessage());
        log.info("Exit:: RestResponseEntityExceptionHandler.java ::: handleException() ::: Request Body-> ResponseDto: {}", responseDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}