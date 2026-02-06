package com.learningspring.springtest.controller;

import com.learningspring.springtest.dto.UserMapper;
import com.learningspring.springtest.dto.UserRequestDTO;
import com.learningspring.springtest.dto.UserResponseDTO;
import com.learningspring.springtest.entity.User;
import com.learningspring.springtest.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO request) {

        User user = userService.createUser(
                request.getTenantId(),
                request.getName(),
                request.getEmail(),
                request.getPassword(), // TEMP
                request.getRole());

        return UserMapper.toResponse(user);
    }

    @GetMapping("/tenant")
    public List<UserResponseDTO> getUsersByTenant(HttpServletRequest request) {

        UUID tenantId = UUID.fromString(
                request.getAttribute("tenantId").toString());

        return userService.getUsersByTenant(tenantId)
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
