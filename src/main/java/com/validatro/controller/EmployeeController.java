package com.validatro.controller;

import com.validatro.beans.Employee;
import com.validatro.config.ErrorResponse;
import com.validatro.config.ResponseWithError;
import com.validatro.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/create")
    @ApiOperation(value = "Register of subject", notes = "URI to register/add subject.", produces = "application/json", consumes = "application/json", response = Employee.class)
    public ResponseEntity<?> createSubject(@RequestBody @Valid Employee employee){

        try {
            String result=employeeService.save(employee);
            return new ResponseEntity(ResponseWithError.of(result), HttpStatus.OK);
        } catch (Exception e) {
          //  log.error("error {}", e)
            return new ResponseEntity(ResponseWithError.ofError("data insertion is failed"),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
