package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@Service
@RequiredArgsConstructor
public class Employee4TService {

    private final EmployeeRepository employeeRepository;

    public Employee save(final Employee employee) {
        return employeeRepository.save(employee);
    }

}