package com.github.thiagogarbazza.pocs.app.web.configuration;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.struts.action.ActionServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

@CommonsLog
@Configuration
class StrutsConfiguration {

    public StrutsConfiguration(final AutowireCapableBeanFactory autowireCapableBeanFactory, final ServletContext servletContext) {
        log.trace("struts configuration: starting");
        log.trace("struts configuration: got autowireCapableBeanFactory: " + (autowireCapableBeanFactory != null));
        log.trace("struts configuration: got servletContext: " + (servletContext != null));
        servletContext.setAttribute("spring.bean.factory", autowireCapableBeanFactory);
    }

    @Bean
    public ServletRegistrationBean<ActionServlet> strutsActionServlet() {
        final var strutsActionServlet = new ActionServlet();

        final var registrationBean = new ServletRegistrationBean<>(strutsActionServlet, "*.do");
        registrationBean.addInitParameter("config",
                "/WEB-INF/struts-config/struts-config.xml"
                        + ",/WEB-INF/struts-config/struts-config-page-employee-delete.xml"
                        + ",/WEB-INF/struts-config/struts-config-page-employee-detail.xml"
                        + ",/WEB-INF/struts-config/struts-config-page-employee-search.xml"
        );
        registrationBean.addInitParameter("debug", "2");
        registrationBean.addInitParameter("detail", "2");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("struts-action-servlet");
        log.trace("struts configuration: registers bean struts-action-servlet");

        return registrationBean;
    }
}
