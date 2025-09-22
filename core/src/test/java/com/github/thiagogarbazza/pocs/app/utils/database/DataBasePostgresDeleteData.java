package com.github.thiagogarbazza.pocs.app.utils.database;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.TreeSet;

import static java.text.MessageFormat.format;
import static java.time.temporal.ChronoUnit.MILLIS;
import static org.apache.commons.lang3.time.DurationFormatUtils.formatDuration;

@Component
@CommonsLog
@RequiredArgsConstructor
public class DataBasePostgresDeleteData {

    private final DataSource dataSource;

    public void all() {
        final LocalDateTime inicio = LocalDateTime.now();
        log.info(format("Postgres - Inicio da remoção dos dados."));
        final Collection<String> tables = tables();
        try (final var connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            final var query = format("TRUNCATE {0} RESTART IDENTITY CASCADE", String.join(",", tables));
            try (final var statement = connection.createStatement()) {
                statement.execute(query);
            }
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException("Postgres - Erro ao remover os dados", e);
        }
        log.info("Postgres - Fim da remoção dos dados em: " + formatDuration(MILLIS.between(inicio, LocalDateTime.now()), "HH:mm:ss.SSS", true));
    }

    private Collection<String> tables() {
        final var tables = new TreeSet<String>();
        try (final var connection = dataSource.getConnection()) {
            try (final var statement = connection.createStatement()) {
                final var query = "SELECT schemaname AS schema, tablename AS table FROM pg_catalog.pg_tables WHERE schemaname NOT IN ('pg_catalog', 'information_schema')";
                try (final var resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        tables.add(resultSet.getString("schema") + "." + resultSet.getString("table"));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Postgres - erro ao buscar as tabelas para remoção.", e);
        }

        return tables;
    }
}
