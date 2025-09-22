package com.github.thiagogarbazza.pocs.app.utils.database.datainit;

import com.github.thiagogarbazza.pocs.app.core.employee.Employee;
import com.github.thiagogarbazza.pocs.app.core.employee.impl.Employee4TService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
class DataEventEmployee implements DataEvent {

    private final Employee4TService employee4TService;

    @Override
    public void execute() {
        employee4TService.save(Employee.builder()
                .id(UUID.fromString("c667022f-cfaa-4b30-a7b6-7e21af2d3383"))
                .email("adamastor-pitaco@comedy.com")
                .name("Adamastor Pitaco")
                .build());

        IntStream.rangeClosed(1, 100).forEach(i -> employee4TService.save(Employee.builder()
                .email("employee" + StringUtils.leftPad(""+ i, 3, "0") + "@algumacoisa.com")
                .name("Employee " + StringUtils.leftPad("" + i, 3, "0"))
                .build()));

    }
}
