package com.github.thiagogarbazza.pocs.app.core.employee;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Builder
@ToString
public class EmployeeDetailDTO {

    private final UUID id;
    private final String name;
    private final String email;

    @QueryProjection
    public EmployeeDetailDTO(final UUID id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
