package com.mycompany.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException mav){

        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = new ErrorModel();
        List<FieldError> fieldErrorList = mav.getBindingResult().getFieldErrors();
        for (FieldError err :
                fieldErrorList) {
            logger.debug("Inside field validation: {} - {}", err.getField(), err.getDefaultMessage());
            logger.info("Inside field validation: {} - {}", err.getField(), err.getDefaultMessage());
            errorModel.setCode(err.getField());
            errorModel.setMessage(err.getDefaultMessage());
            errorModelList.add(errorModel);
        }
        System.out.println("Field Error:");
        return  new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException bex){
        System.out.println("BusinessException is thrown");
        for (ErrorModel err :
                bex.getErrors()) {
            logger.debug("BusinessException is thrown - levelDebug", err.getCode(), err.getMessage());
            logger.info("BusinessException is thrown - levelInfo", err.getCode(), err.getMessage());
            logger.warn("BusinessException is thrown - levelWarn", err.getCode(), err.getMessage());
            logger.error("BusinessException is thrown - levelError", err.getCode(), err.getMessage());
        }

        return new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
