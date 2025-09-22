package com.github.thiagogarbazza.pocs.app.web;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.AbstractEnvironment;

class ApplicationWebLocal {

    public static void main(final String... args) {
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "app,web,local,test");

        SpringApplication.run(ApplicationWeb.class, args);
    }
}