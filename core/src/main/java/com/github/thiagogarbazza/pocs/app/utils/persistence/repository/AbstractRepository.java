package com.github.thiagogarbazza.pocs.app.utils.persistence.repository;

import com.querydsl.core.types.Expression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.querydsl.QPageRequest;

import java.util.Collections;

public abstract class AbstractRepository<T> extends QuerydslRepositorySupport {

    protected AbstractRepository(Class<T> domainClass) {
        super(domainClass);
    }

    protected <P> Page<P> findPage(final JPQLQuery<?> query, final QPageRequest pageable, final Expression<P> projection) {
        final var total = query.fetchCount();

        final var content = total > pageable.getOffset()
                ? getQuerydsl().applyPagination(pageable, query)
                .select(projection)
                .fetch()
                : Collections.<P>emptyList();

        return new PageImpl<>(content);
    }
}
