package com.example.app.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    @Email(message = "Must to be a valid email")
    @Size(min = 6)
    private String email;

    @Size(min = 8, message = "Password must contains at least 8 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password do not have all required elements")
    private String password;
}
