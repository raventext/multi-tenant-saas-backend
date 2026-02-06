package com.learningspring.springtest.service;

import com.learningspring.springtest.entity.Tenant;
import com.learningspring.springtest.entity.User;
import com.learningspring.springtest.repository.TenantRepository;
import com.learningspring.springtest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TenantRepository tenantRepository;

    public User createUser(UUID tenantId, String name, String email, String password, String role) {

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        User user = User.builder()
                .name(name)
                .email(email)
                .password(password) // TEMP
                .role(role)
                .tenant(tenant)
                .build();

        return userRepository.save(user);
    }

    public List<User> getUsersByTenant(UUID tenantId) {
        return userRepository.findByTenantId(tenantId);
    }
}
