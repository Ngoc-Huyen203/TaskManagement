package com.huyen.taskmanagement.dto.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;

    private String tokenType = "Bearer";

    private Long expiresIn;

    private UserResponse user;

}