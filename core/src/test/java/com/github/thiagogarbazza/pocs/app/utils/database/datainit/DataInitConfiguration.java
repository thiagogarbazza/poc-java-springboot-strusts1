package com.github.thiagogarbazza.pocs.app.utils.database.datainit;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"local"})
@Import({DataInitListener.class})
class DataInitConfiguration {
}
