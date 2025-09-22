package com.github.thiagogarbazza.pocs.app.utils.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.sql.DataSource;
import static java.text.MessageFormat.format;
import static java.time.temporal.ChronoUnit.MILLIS;
import static org.apache.commons.lang3.time.DurationFormatUtils.formatDuration;

@Component
@CommonsLog
@RequiredArgsConstructor
public class DataBasePostgresSchemaFactory {

    private static final MutableBoolean DB_CREATED = new MutableBoolean(false);
    private static final String PACKAGES_TO_SCAN = "com.github.thiagogarbazza.pocs.app.**";

    private final DataSource dataSource;
    private final Environment environment;

    public void create() {
        if (DB_CREATED.booleanValue() || alreadyCreated()) {
            log.info("Postgres - Schema criado anteriormente.");
            return;
        }
        final LocalDateTime inicio = LocalDateTime.now();
        log.info("Postgres - Criando schema.");
        createTables();
        log.info("Postgres - Schema criado em: " + formatDuration(MILLIS.between(inicio, LocalDateTime.now()), "HH:mm:ss.SSS", true));
    }

    private boolean alreadyCreated() {
        try (final var connection = dataSource.getConnection()) {
            try (final var statement = connection.createStatement()) {
                final var query = "SELECT 1 AS COUNT FROM pg_catalog.pg_tables WHERE schemaname NOT IN ('pg_catalog', 'information_schema') FETCH FIRST 1 ROWS ONLY";
                try (final var resultSet = statement.executeQuery(query)) {
                    if (resultSet.next()) {
                        DB_CREATED.setValue(resultSet.getInt("COUNT") == 1);
                        return DB_CREATED.booleanValue();
                    }
                    return false;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(format("Postgres - Erro ao verificar se o schema já foi criado."), e);
        }
    }

    private void createTables() {
        final String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        final var properties = new Properties();
        properties.setProperty("hibernate.connection.driver_class", environment.getProperty("spring.datasource.driver-class-name"));
        properties.setProperty("hibernate.connection.url", environment.getProperty("spring.datasource.url"));
        properties.setProperty("hibernate.connection.username", environment.getProperty("spring.datasource.username"));
        properties.setProperty("hibernate.connection.password", environment.getProperty("spring.datasource.password"));
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.format_sql", "false");
        properties.setProperty("hibernate.ddl-auto", "create");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.hbm2ddl.create_namespaces", "true");
        properties.setProperty("javax.persistence.create-database-schemas", "true");
        properties.setProperty("javax.persistence.schema-generation.create-database-schemas", "true");
        properties.setProperty("javax.persistence.schema-generation.create-source", "metadata");
        properties.setProperty("javax.persistence.schema-generation.drop-source", "metadata");
        properties.setProperty("javax.persistence.schema-generation.database.action", "create");
        properties.setProperty("javax.persistence.schema-generation.scripts.action", "create");
        properties.setProperty("javax.persistence.schema-generation.scripts.create-target", basePath + "/../data-base/create.sql");
        properties.setProperty("javax.persistence.schema-generation.scripts.drop-target", basePath + "/../data-base/drop.sql");

        final var entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(properties);
        entityManagerFactoryBean.afterPropertiesSet();
    }
}
