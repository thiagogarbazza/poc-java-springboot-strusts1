package com.github.thiagogarbazza.pocs.app.web;

import com.github.thiagogarbazza.pocs.app.CoreConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import static java.util.Objects.isNull;

@EnableAsync
@EnableWebMvc
@Configuration
@EnableAutoConfiguration
@Import(CoreConfiguration.class)
@ComponentScan(basePackages = {
        "com.github.thiagogarbazza.pocs.app.web"
})
public class ApplicationWeb extends SpringBootServletInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        if (isNull(System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME))) {
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "app,web");
        }

        super.onStartup(servletContext);
    }
}
