package com.huyen.taskmanagement.service;

import com.huyen.taskmanagement.dto.request.CreateUserRequest;
import com.huyen.taskmanagement.dto.request.UpdateUserRequest;
import com.huyen.taskmanagement.dto.response.UserResponse;

import java.util.List;


public interface UserService {
    UserResponse createUser(CreateUserRequest request);

    UserResponse updateUser(Long id, UpdateUserRequest request);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    void deleteUser(Long id);
}
