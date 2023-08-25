package com.shinn.employeeservice.service;

import com.shinn.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping(path = "api/departments/{code}")
   DepartmentDto findByDepartmentCode(@PathVariable("code") String code);
}
