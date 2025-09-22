package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeDetailDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeDetailService;
import com.github.thiagogarbazza.pocs.app.utils.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class EmployeeDetailServiceImpl implements EmployeeDetailService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDetailDTO detail(UUID id) {
        final var employee = employeeRepository.findById(id)
                .orElseThrow(() -> NotFoundException.of("Employee not found: " + id));

        return EmployeeDetailDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();
    }
}
