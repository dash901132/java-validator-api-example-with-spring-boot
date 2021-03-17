package com.validatro.config;
import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import java.util.*;

@ControllerAdvice
@RestController
class ExceptionHandlerAdvice{

//private val log = LoggerFactory.getLogger(EmployeeController.class);

@ExceptionHandler(value = MethodArgumentNotValidException.class)
public ResponseWithError<?> handleException(MethodArgumentNotValidException e, WebRequest request) {

       BindingResult result= e.getBindingResult();

        List<FieldError> fieldError = result.getFieldErrors();

        List<String> errorDetails = new ArrayList<>();

        for (FieldError error : fieldError) {

        errorDetails.add(error.getField()+":"+error.getDefaultMessage());
        }
    ErrorMessages errorMessage = new ErrorMessages();

    return ResponseWithError.ofError(errorDetails.toString());
        }


@ExceptionHandler(Exception.class)
   public ResponseWithError<?>handleException( Exception e,WebRequest request){
        if (e instanceof MethodArgumentNotValidException) {
            System.out.println("");
        }
        //log.error("error{}", e)
        return ResponseWithError.ofError("Something went Wrong");  }

        }
