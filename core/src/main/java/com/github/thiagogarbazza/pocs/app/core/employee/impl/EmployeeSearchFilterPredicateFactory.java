package com.github.thiagogarbazza.pocs.app.core.employee.impl;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchFilterDTO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
class EmployeeSearchFilterPredicateFactory {

    public static Predicate create(EmployeeSearchFilterDTO employeeSearchFilterDTO) {
        return new BooleanBuilder();
    }
}
