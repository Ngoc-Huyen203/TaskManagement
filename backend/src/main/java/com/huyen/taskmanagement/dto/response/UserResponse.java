package com.huyen.taskmanagement.dto.response;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponse {

    private Long id;

    private String username;

    private String email;

    private String fullName;

    private String phone;

    private Boolean enabled;

    private Set<String> roles;

}