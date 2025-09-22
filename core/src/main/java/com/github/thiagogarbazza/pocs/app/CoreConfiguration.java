package com.github.thiagogarbazza.pocs.app;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan({
        "com.github.thiagogarbazza.pocs.app.core",
        "com.github.thiagogarbazza.pocs.app.utils"
})
@ComponentScan(basePackages = {
        "com.github.thiagogarbazza.pocs.app.core",
        "com.github.thiagogarbazza.pocs.app.utils"
})
@EnableJpaRepositories(basePackages = {
        "com.github.thiagogarbazza.pocs.app.core",
        "com.github.thiagogarbazza.pocs.app.utils"
})
public class CoreConfiguration {
}
