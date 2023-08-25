package com.shinn.employeeservice.service.impl;

import com.shinn.employeeservice.dto.APIResponseDto;
import com.shinn.employeeservice.dto.DepartmentDto;
import com.shinn.employeeservice.dto.EmployeeDto;
import com.shinn.employeeservice.entity.Employee;
import com.shinn.employeeservice.repository.EmployeeRepository;
import com.shinn.employeeservice.service.APIClient;
import com.shinn.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

//    private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        employee = employeeRepository.save(employee);
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
    }

    @Override
    public APIResponseDto findById(Long id) {
        Optional<Employee> optionalEmployee= employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
//            ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//                    DepartmentDto.class);
//            DepartmentDto departmentDto = responseEntity.getBody();

//            DepartmentDto departmentDto = webClient.get()
//                    .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                    .retrieve()
//                    .bodyToMono(DepartmentDto.class)
//                    .block();
            DepartmentDto departmentDto = apiClient.findByDepartmentCode(employee.getDepartmentCode());

            EmployeeDto employeeDto = new EmployeeDto(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getDepartmentCode()
            );
            APIResponseDto apiResponseDto = new APIResponseDto(employeeDto, departmentDto);

            return apiResponseDto;
        }
        throw new NoSuchElementException("Not found");
    }
}
