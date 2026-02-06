package com.learningspring.springtest.dto;

import com.learningspring.springtest.entity.User;

public class UserMapper {

    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole());
    }
}
