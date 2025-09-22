package com.github.thiagogarbazza.pocs.app.utils.persistence.repository;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractFilterTest {

    @Test
    void verifyGetPageNumber() {
        assertAll(
                () -> assertEquals(0, Filter.builder().build().getPn(), "ZERO when not informed"),
                () -> assertEquals(0, Filter.builder().pn(-1).build().getPn(), "ZERO when informed negative number"),
                () -> assertEquals(0, Filter.builder().pn(0).build().getPn(), "ZERO when informed zero"),
                () -> assertEquals(1, Filter.builder().pn(1).build().getPn(), "Number informed")
        );
    }

    @Test
    void verifyGetPageSize() {
        assertAll(
                () -> assertEquals(10, Filter.builder().build().getPs(), "TEN when not informed"),
                () -> assertEquals(10, Filter.builder().ps(-1).build().getPs(), "TEN when informed negative number"),
                () -> assertEquals(10, Filter.builder().ps(0).build().getPs(), "TEN when informed zero"),
                () -> assertEquals(1, Filter.builder().ps(1).build().getPs(), "Number informed")
        );
    }

    @SuperBuilder
    @Getter
    static class Filter extends AbstractFilter {
        private final String text;
    }

}