package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.Employee;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchFilterDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchResultDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.QEmployeeSearchResultDTO;
import com.github.thiagogarbazza.pocs.app.utils.persistence.repository.AbstractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Repository;

import static com.github.thiagogarbazza.pocs.app.core.employee.QEmployee.employee;

@Repository
class EmployeeRepositoryImpl extends AbstractRepository<Employee> implements EmployeeRepositoryCustom {

    protected EmployeeRepositoryImpl() {
        super(Employee.class);
    }

    @Override
    public Page<EmployeeSearchResultDTO> search(EmployeeSearchFilterDTO employeeSearchFilterDTO) {
        final var query = from(employee)
                .where(EmployeeSearchFilterPredicateFactory.create(employeeSearchFilterDTO));
        final var projection = new QEmployeeSearchResultDTO(employee.id, employee.name);
        final var pageable = QPageRequest.of(employeeSearchFilterDTO.getPn(), employeeSearchFilterDTO.getPs());

        return findPage(query, pageable, projection);
    }
}
