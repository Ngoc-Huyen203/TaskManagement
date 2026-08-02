package com.huyen.taskmanagement.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateUserRequest {

    @Email(message = "Email is invalid")
    private String email;

    private String fullName;

    private String phone;

    private Boolean enabled;

    private Set<Long> roleIds;

}