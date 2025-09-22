package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class EmployeeDeleteServiceImpl implements EmployeeDeleteService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}
