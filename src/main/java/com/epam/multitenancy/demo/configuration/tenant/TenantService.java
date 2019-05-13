package com.epam.multitenancy.demo.configuration.tenant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public boolean knownTenant(String tenantId) {
        return tenantId != null && tenantRepository.findById(tenantId).isPresent();
    }
}
