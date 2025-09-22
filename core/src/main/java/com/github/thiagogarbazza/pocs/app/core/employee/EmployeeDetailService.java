package com.github.thiagogarbazza.pocs.app.core.employee;

import java.util.UUID;

public interface EmployeeDetailService {

    EmployeeDetailDTO detail(final UUID id);
}
