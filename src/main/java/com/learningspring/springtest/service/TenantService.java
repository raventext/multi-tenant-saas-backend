package com.learningspring.springtest.service;

import com.learningspring.springtest.entity.Tenant;
import com.learningspring.springtest.repository.TenantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantService {

    private final TenantRepository tenantRepository;

    public Tenant createTenant(String name) {
        if (tenantRepository.existsByName(name)) {
            throw new RuntimeException("Tenant already exists");
        }

        Tenant tenant = Tenant.builder()
                .name(name)
                .active(true)
                .build();

        return tenantRepository.save(tenant);
    }
}
