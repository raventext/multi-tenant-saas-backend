package com.learningspring.springtest.controller;

import com.learningspring.springtest.dto.LoginRequestDTO;
import com.learningspring.springtest.dto.LoginResponseDTO;
import com.learningspring.springtest.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        String token = authService.login(
                request.getEmail(),
                request.getPassword());
        return new LoginResponseDTO(token);
    }
}
