package org.sekator.jdbi3.configuration;


import org.jdbi.v3.core.ConnectionFactory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.spring5.SpringConnectionFactory;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author dn070578noi
 * @created 22 кві, 2024
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSourceProperties properties = new DataSourceProperties();
        properties.setDriverClassName("org.postgresql.Driver");
        properties.setUrl("jdbc:postgresql://localhost:5432/jdbi_test");
        properties.setUsername("postgres");
        properties.setPassword("password");

        return properties.initializeDataSourceBuilder().build();
    }

    @Bean
    public Jdbi jdbi(DataSource dataSource) {
        ConnectionFactory connectionFactory = new SpringConnectionFactory(dataSource);
        Jdbi jdbi = Jdbi.create(connectionFactory);

        jdbi.installPlugin(new SqlObjectPlugin());
        jdbi.installPlugin(new PostgresPlugin());

        return jdbi;
    }
}