package com.shinn.employeeservice.service;

import com.shinn.employeeservice.dto.APIResponseDto;
import com.shinn.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);
    APIResponseDto findById(Long id);
}
