package com.example.backend.demo.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class RegistrationController
{
    private final RegistrationService service;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse> register(
            @RequestBody RegistrationRequest request)
    {
        return ResponseEntity.ok(service.register(request));
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirm()
    {
        return ResponseEntity.ok("Your account has been successfully activated.");
    }
}
