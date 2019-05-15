package com.example.sandbox.springboothibernateormxml.configuration;


import com.zaxxer.hikari.HikariDataSource;
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.engine.jdbc.internal.Formatter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({DataSourceProperties.class})
public class JpaConfiguration {

    // use hibernate to format queries
    private static class PrettyQueryEntryCreator extends DefaultQueryLogEntryCreator {
        private Formatter formatter = FormatStyle.BASIC.getFormatter();

        @Override
        protected String formatQuery(String query) {
            return this.formatter.format(query);
        }
    }


    private DataSource wrapWithLoggingProxy(DataSource actualDataSource) {
        // use pretty formatted query with multiline enabled
        PrettyQueryEntryCreator creator = new PrettyQueryEntryCreator();
        creator.setMultiline(true);

        SLF4JQueryLoggingListener listener = new SLF4JQueryLoggingListener();
        listener.setQueryLogEntryCreator(creator);

        return ProxyDataSourceBuilder
                .create(actualDataSource)
                .name("MyDS")
                .listener(listener)
                .build();
    }

    @Bean
    //@Named("actual")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource getActualDataSource(DataSourceProperties properties) {
        HikariDataSource hikariDataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        return wrapWithLoggingProxy(hikariDataSource);
    }

}
