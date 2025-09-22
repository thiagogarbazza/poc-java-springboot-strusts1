package com.github.thiagogarbazza.pocs.app.utils.persistence.repository;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.Optional;

@Getter
@SuperBuilder
public class AbstractFilter {

    private final Integer pn;
    private final Integer ps;
    private final Collection<String> sort;

    public final int getPn() {
        return Optional.ofNullable(pn)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public final int getPs() {
        return Optional.ofNullable(ps)
                .filter(i -> i >= 0)
                .orElse(10);
    }
}
