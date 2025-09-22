package com.github.thiagogarbazza.pocs.app.web.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@UtilityClass
public class RequestParameterUtils {

    public static Integer getInteger(final HttpServletRequest request, final String paramName) {
        final String value = getString(request, paramName);

        return Optional.ofNullable(value)
                .map(Integer::valueOf)
                .orElse(null);
    }

    public static Optional<UUID> getOptionalUUID(final HttpServletRequest request, final String paramName) {
        final String value = getString(request, paramName);

        return Optional.ofNullable(value)
                .map(UUID::fromString);
    }

    public static String getString(final HttpServletRequest request, final String paramName) {
        final String value = request.getParameter(paramName);

        return StringUtils.trimToNull(value);
    }

    public static Collection<String> getStrings(final HttpServletRequest request, final String paramName) {
        final String[] value = request.getParameterValues(paramName);

        return Optional.ofNullable(value).map(Arrays::asList).orElse(Collections.emptyList()).stream()
                .map(StringUtils::trimToNull)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toSet());
    }
}
