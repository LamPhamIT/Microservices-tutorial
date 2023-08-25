package com.shinn.departmentservice.controller;

import com.shinn.departmentservice.dto.DepartmentDto;
import com.shinn.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto departmentDtoReturn = departmentService.save(departmentDto);
        return  new ResponseEntity<>(departmentDtoReturn, HttpStatus.CREATED);
    }
    @GetMapping(path = "{code}")
    public ResponseEntity<DepartmentDto> findByDepartmentCode(@PathVariable("code") String code){
        DepartmentDto departmentDto = departmentService.findByCode(code);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
