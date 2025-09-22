package com.github.thiagogarbazza.pocs.app.job;

import com.github.thiagogarbazza.pocs.app.CoreConfiguration;
import com.github.thiagogarbazza.pocs.app.job.jobs.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;

import java.util.Arrays;

@CommonsLog
@RequiredArgsConstructor
@EnableAutoConfiguration
@Import(CoreConfiguration.class)
@ComponentScan(basePackages = {
        "com.github.thiagogarbazza.pocs.app.job"
})
public class ApplicationJob implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public static void main(final String... args) {
        if (System.getProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME) == null) {
            System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "app,job");
        }

        final ConfigurableApplicationContext configurableApplicationContext = new SpringApplicationBuilder()
                .sources(ApplicationJob.class)
                .build()
                .run(args);

        final int exit = SpringApplication.exit(configurableApplicationContext);
        System.exit(exit);
    }

    @Override
    public void run(final String... args) throws Exception {
        final String jobName = Arrays.stream(args).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No job name provided!"));

        final JobService jobService = applicationContext.getBean(jobName, JobService.class);
        jobService.run();
    }
}
