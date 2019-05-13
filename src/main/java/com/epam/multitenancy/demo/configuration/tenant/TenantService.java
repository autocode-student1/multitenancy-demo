package com.epam.multitenancy.demo.configuration.tenant;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    private final JdbcTemplate jdbcTemplate;

    public Tenant registerTenant(String tenantId, String barbers) {
        validateTenant(tenantId);

        Tenant registeredTenant = tenantRepository.saveAndFlush(new Tenant(tenantId));

        jdbcTemplate.update("CREATE SCHEMA " + tenantId);
        jdbcTemplate.update("SET SCHEMA " + tenantId);
        jdbcTemplate.update("CREATE TABLE BARBER (ID int not null auto_increment, NAME varchar(100) not null)");
        jdbcTemplate.update("CREATE TABLE APPOINTMENT (ID int not null auto_increment, BARBER_ID int, " +
                "DATE_TIME timestamp, CLIENT_NAME  varchar(100), CLIENT_PHONE varchar(100))");

        Stream.of(barbers.split(","))
                .map(String::trim)
                .forEach(barber -> jdbcTemplate.update("INSERT INTO BARBER(name) VALUES (?)", barber));

        return registeredTenant;
    }

    private void validateTenant(String tenantId) {
        Pattern pattern = Pattern.compile("^[a-z][a-z0-9_]{0,15}$");
        if (!pattern.matcher(tenantId).matches()) {
            throw new IllegalArgumentException("Illegal Tenant ID: " + tenantId);
        }

        if (knownTenant(tenantId)) {
            throw new IllegalArgumentException("Tenant already exists: " + tenantId);
        }
    }

    public boolean knownTenant(String tenantId) {
        return tenantId != null && tenantRepository.findById(tenantId).isPresent();
    }
}
