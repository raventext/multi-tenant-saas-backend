package com.learningspring.springtest.dto;

import java.util.UUID;

public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String role;

    public UserResponseDTO(UUID id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    // getters only (response should be immutable)
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
