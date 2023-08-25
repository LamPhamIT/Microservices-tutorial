package com.shinn.departmentservice.service;

import com.shinn.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto);
    DepartmentDto findByCode(String code);
}
