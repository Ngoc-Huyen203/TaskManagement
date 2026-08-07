package com.huyen.taskmanagement.service.impl;

import com.huyen.taskmanagement.dto.request.CreateUserRequest;
import com.huyen.taskmanagement.dto.request.UpdateUserRequest;
import com.huyen.taskmanagement.dto.response.UserResponse;
import com.huyen.taskmanagement.entity.User;
import com.huyen.taskmanagement.exception.DuplicateResourceException;
import com.huyen.taskmanagement.exception.ResourceNotFoundException;
import com.huyen.taskmanagement.mapper.UserMapper;
import com.huyen.taskmanagement.repository.UserRepository;
import com.huyen.taskmanagement.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    // TODO(Security): Encode password before saving user.

    // TODO(Role): Map roleIds to Role entities.

    // TODO(History): Record user creation/update/delete history.

    // TODO(Notification): Send notification after user changes.

    // TODO(Pagination): Replace getAllUsers() with pageable query.

    // TODO(Soft Delete): Filter deleted users in repository.

    // TODO(Transaction): Add @Transactional when service spans multiple write operations.

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        if(userRepository.existsByUsername(request.getUsername())){
            throw new DuplicateResourceException("Username " + request.getUsername() +" already exists");
        }

        User user = userMapper.toEntity(request);

        // TODO: Encode password after integrating Spring Security
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saveUser = userRepository.save(user);

        return userMapper.toResponse(saveUser);
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        userMapper.updateEntityFromRequest(request, user);

        User saveUser = userRepository.save(user);

        return userMapper.toResponse(saveUser);
    }

    @Override
    public UserResponse getUserById(Long id) {
        // logic lấy user theo id
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User id not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        // logic lấy tất cả user
        List<User> users = userRepository.findAll();

        return userMapper.toResponseList(users);
    }

    @Override
    public void deleteUser(Long id) {
        // logic xóa user
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User Id not found"));

        user.setDeleted(true);
        userRepository.save(user);
    }
}

