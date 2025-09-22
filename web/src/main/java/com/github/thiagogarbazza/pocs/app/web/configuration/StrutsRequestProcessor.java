package com.github.thiagogarbazza.pocs.app.web.configuration;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.RequestProcessor;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@CommonsLog
public class StrutsRequestProcessor extends RequestProcessor {

    private final Set<String> autowiredTypes = new HashSet<>();

    @Override
    protected Action processActionCreate(final HttpServletRequest request, final HttpServletResponse response, final ActionMapping mapping) throws IOException {
        final var action = super.processActionCreate(request, response, mapping);
        if (nonNull(action)) {
            autowireBean(request, action, mapping.getType());
        }

        return action;
    }

    private void autowireBean(final HttpServletRequest request, final Action action, final String actionType) {
        if (autowiredTypes.contains(actionType)) {
            return;
        }

        log.trace("spring-struts start autowire-bean: " + actionType);
        final var beanFactory = (AutowireCapableBeanFactory) request.getServletContext().getAttribute("spring.bean.factory");
        beanFactory.autowireBean(action);
        autowiredTypes.add(actionType);
        log.trace("spring-struts end autowire-bean: " + actionType);
    }
}
