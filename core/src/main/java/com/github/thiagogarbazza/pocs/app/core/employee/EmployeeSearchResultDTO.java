package com.github.thiagogarbazza.pocs.app.core.employee;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Builder
@ToString
public class EmployeeSearchResultDTO {

    private final UUID id;
    private final String name;

    @QueryProjection
    public EmployeeSearchResultDTO(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }
}
