package com.huyen.taskmanagement.controller;

import com.huyen.taskmanagement.dto.request.CreateUserRequest;
import com.huyen.taskmanagement.dto.request.UpdateUserRequest;
import com.huyen.taskmanagement.dto.response.ApiResponse;
import com.huyen.taskmanagement.dto.response.UserResponse;
import com.huyen.taskmanagement.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse<UserResponse>> createUser(
            @Valid @RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User created successfully")
                        .data(response)
                        .build()
        );

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUserById(
            @PathVariable Long id, @Valid @RequestBody UpdateUserRequest request) {
        UserResponse response = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User updated successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        UserResponse response = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<UserResponse>builder()
                        .success(true)
                        .message("User fetched successfully")
                        .data(response)
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers(){
        List<UserResponse> userResponseList = userService.getAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<List<UserResponse>>builder()
                        .success(true)
                        .message("User list retrieved successfully")
                        .data(userResponseList)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                ApiResponse.<Void>builder()
                        .success(true)
                        .message("User deleted successfully")
                        .data(null)
                        .build()
        );
    }
}
