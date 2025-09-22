package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface EmployeeRepository extends EmployeeRepositoryCustom, JpaRepository<Employee, UUID> {
}
