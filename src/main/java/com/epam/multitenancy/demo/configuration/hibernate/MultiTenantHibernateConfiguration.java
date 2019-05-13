package com.epam.multitenancy.demo.configuration.hibernate;

import com.epam.multitenancy.demo.configuration.web.TenantHolder;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
public class MultiTenantHibernateConfiguration {

    @Bean
    public CurrentTenantIdentifierResolver tenantIdentifierResolver() {
        return new CurrentTenantIdentifierResolver() {
            @Override
            public String resolveCurrentTenantIdentifier() {
                return TenantHolder.getTenantId();
            }

            @Override
            public boolean validateExistingCurrentSessions() {
                return false;
            }
        };
    }

    @Bean
    public MultiTenantConnectionProvider multiTenantConnectionProvider(DataSource dataSource) {
        return new AbstractDataSourceBasedMultiTenantConnectionProviderImpl() {
            @Override
            protected DataSource selectAnyDataSource() {
                return dataSource;
            }

            @Override
            protected DataSource selectDataSource(String tenantIdentifier) {
                return dataSource;
            }

            @Override
            public Connection getConnection(String tenantIdentifier) throws SQLException {
                Connection connection = dataSource.getConnection();
                connection.createStatement().execute(String.format("SET SCHEMA %s", tenantIdentifier));
                return connection;
            }
        };
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(CurrentTenantIdentifierResolver tenantIdentifierResolver,
                                                                       MultiTenantConnectionProvider multiTenantConnectionProvider) {
        return properties -> {
            properties.put(MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
            properties.put(MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
            properties.put(MULTI_TENANT_IDENTIFIER_RESOLVER, tenantIdentifierResolver);
        };
    }
}
