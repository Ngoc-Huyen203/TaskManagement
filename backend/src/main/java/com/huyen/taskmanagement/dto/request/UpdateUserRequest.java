package com.huyen.taskmanagement.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserRequest {

    @Email(message = "Email is invalid")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;

    @Size(max = 20, message = "Phone must not exceed 20 characters")
    private String phone;

    private Boolean enabled;

    private Set<Long> roleIds;

}