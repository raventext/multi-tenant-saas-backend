package com.learningspring.springtest.repository;

import com.learningspring.springtest.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TenantRepository extends JpaRepository<Tenant, UUID> {
    boolean existsByName(String name);
}
