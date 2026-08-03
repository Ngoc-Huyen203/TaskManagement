package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.request.CreateUserRequest;
import com.huyen.taskmanagement.dto.request.UpdateUserRequest;
import com.huyen.taskmanagement.dto.response.UserResponse;
import com.huyen.taskmanagement.entity.Role;
import com.huyen.taskmanagement.entity.User;
import org.mapstruct.*;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(mapRoles(user.getRoles()))")
    UserResponse toResponse(User user);

    @Mapping(target = "roles", ignore = true)
    User toEntity(CreateUserRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    void updateEntityFromRequest(UpdateUserRequest request,
                                 @MappingTarget User user);

    default Set<String> mapRoles(Set<Role> roles) {

        if (roles == null) {
            return Collections.emptySet();
        }

        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }
}