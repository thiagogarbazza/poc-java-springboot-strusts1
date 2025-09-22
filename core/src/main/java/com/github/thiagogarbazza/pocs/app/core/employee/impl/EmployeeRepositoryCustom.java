package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchFilterDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchResultDTO;
import org.springframework.data.domain.Page;

interface EmployeeRepositoryCustom {

    Page<EmployeeSearchResultDTO> search(EmployeeSearchFilterDTO employeeSearchFilterDTO);
}
