package com.learningspring.springtest.repository;

import com.learningspring.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findByTenantId(UUID tenantId);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
