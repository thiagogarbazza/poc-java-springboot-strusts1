package com.github.thiagogarbazza.pocs.app.utils.database.datainit;

import com.github.thiagogarbazza.pocs.app.utils.database.DataBasePostgresDeleteData;
import com.github.thiagogarbazza.pocs.app.utils.database.DataBasePostgresSchemaFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

@CommonsLog
@RequiredArgsConstructor
class DataInitListener implements ApplicationListener<ApplicationStartedEvent> {

    private final DataBasePostgresSchemaFactory dataBasePostgresSchemaFactory;
    private final DataBasePostgresDeleteData dataBasePostgresDeleteData;
    private final List<DataEvent> dataEvents;


    @Override
    public void onApplicationEvent(final ApplicationStartedEvent event) {
        dataBasePostgresSchemaFactory.create();
        dataBasePostgresDeleteData.all();

        log.info("Executing data init events...");
        dataEvents.forEach(DataEvent::execute);
        log.info("Done data init events");
    }
}
