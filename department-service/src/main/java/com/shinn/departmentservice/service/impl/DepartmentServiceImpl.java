package com.shinn.departmentservice.service.impl;

import com.shinn.departmentservice.dto.DepartmentDto;
import com.shinn.departmentservice.entity.Department;
import com.shinn.departmentservice.repository.DepartmentRepository;
import com.shinn.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        Department department = new Department(null,
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        department = departmentRepository.save(department);
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto findByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
}
