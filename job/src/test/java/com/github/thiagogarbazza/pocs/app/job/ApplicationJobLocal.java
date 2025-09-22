package com.github.thiagogarbazza.pocs.app.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.AbstractEnvironment;

class ApplicationJobLocal {

    private static final String JOB_NAME = "ExampleJob";

    public static void main(final String... args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "app,job,local,test");

        final ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder()
                .sources(ApplicationJob.class)
                .build()
                .run(JOB_NAME);

        final int exit = SpringApplication.exit(configurableApplicationContext);
        System.exit(exit);
    }
}