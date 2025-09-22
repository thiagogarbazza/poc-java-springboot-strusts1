package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchFilterDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchResultDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class EmployeeSearchServiceImpl implements EmployeeSearchService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeSearchResultDTO> search(EmployeeSearchFilterDTO employeeSearchFilterDTO) {
        return employeeRepository.search(employeeSearchFilterDTO);
    }
}
