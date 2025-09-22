package com.github.thiagogarbazza.pocs.app.job.jobs;

import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchFilterDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchResultDTO;
import com.github.thiagogarbazza.pocs.app.core.employee.EmployeeSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@CommonsLog
@Service("ExampleJob")
@RequiredArgsConstructor
class ExampleJobService implements JobService {

    private final EmployeeSearchService employeeSearchService;

    @Override
    public void run() {
        log.info("Passei por aqui.");

        final EmployeeSearchFilterDTO filter = EmployeeSearchFilterDTO.builder().build();
        final Page<EmployeeSearchResultDTO> itens = employeeSearchService.search(filter);

        log.info(itens.getContent().toString());
    }
}
