package com.shinn.employeeservice.controller;

import com.shinn.employeeservice.dto.APIResponseDto;
import com.shinn.employeeservice.dto.EmployeeDto;
import com.shinn.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employeeReturn = employeeService.save(employeeDto);
        return new ResponseEntity<>(employeeReturn, HttpStatus.CREATED);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<APIResponseDto> findById(@PathVariable("id") Long id) {
        APIResponseDto apiResponseDto = employeeService.findById(id);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

}
