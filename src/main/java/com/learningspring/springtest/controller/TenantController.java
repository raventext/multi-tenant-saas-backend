package com.learningspring.springtest.controller;

import com.learningspring.springtest.entity.Tenant;
import com.learningspring.springtest.service.TenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
@RequiredArgsConstructor
public class TenantController {

    private final TenantService tenantService;

    @PostMapping
    public Tenant createTenant(@RequestParam String name) {
        return tenantService.createTenant(name);
    }
}
