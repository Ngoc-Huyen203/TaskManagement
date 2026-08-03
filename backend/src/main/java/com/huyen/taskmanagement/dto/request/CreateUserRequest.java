package com.huyen.taskmanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class CreateUserRequest {

    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username must not exceed 50 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(max = 255, message = "Password must not exceed 255 characters")
    private String password;

    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;

    @Size(max = 20, message = "Phone must not exceed 20 characters")
    private String phone;

    @NotEmpty(message = "At least one role is required")
    private Set<Long> roleIds;

}