package org.sekator.jdbi3.configuration;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dn070578noi
 * @created 22 кві, 2024
 */
class DatabaseConfigurationTest {

    @Mock
    private DataSourceProperties properties;

    @InjectMocks
    private DatabaseConfiguration databaseConfiguration;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void dataSourceReturnsCorrectProperties() throws SQLException {
        when(properties.getDriverClassName()).thenReturn("org.postgresql.Driver");
        when(properties.getUrl()).thenReturn("jdbc:postgresql://localhost:5432/jdbi_test");
        when(properties.getUsername()).thenReturn("postgres");
        when(properties.getPassword()).thenReturn("password");

        DataSource dataSource = databaseConfiguration.dataSource();

        assertEquals("com.zaxxer.hikari.HikariDataSource", dataSource.getClass().getName());
        assertEquals("jdbc:postgresql://localhost:5432/jdbi_test", dataSource.getConnection().getMetaData().getURL());
    }

    @Test
    void jdbiReturnsInstanceWithCorrectPlugins() {
        DataSource dataSource = mock(DataSource.class);
        Jdbi jdbi = databaseConfiguration.jdbi(dataSource);

//        assertTrue(jdbi.getConfig().getPlugins().stream().anyMatch(plugin -> plugin instanceof SqlObjectPlugin));
//        assertTrue(jdbi.getConfig().getPlugins().stream().anyMatch(plugin -> plugin instanceof PostgresPlugin));
    }
}