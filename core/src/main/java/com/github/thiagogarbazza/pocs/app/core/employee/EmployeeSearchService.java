package com.github.thiagogarbazza.pocs.app.core.employee;

import org.springframework.data.domain.Page;

public interface EmployeeSearchService {

    Page<EmployeeSearchResultDTO> search(EmployeeSearchFilterDTO employeeSearchFilterDTO);
}
