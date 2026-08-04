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

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface UserMapper {

    @Mapping(target = "roles", source = "roles")
    UserResponse toResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)

    @Mapping(target = "enabled", ignore = true)

    @Mapping(target = "createdTasks", ignore = true)
    @Mapping(target = "assignedTasks", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "attachments", ignore = true)
    @Mapping(target = "histories", ignore = true)
    @Mapping(target = "sentNotifications", ignore = true)
    @Mapping(target = "receivedNotifications", ignore = true)
    User toEntity(CreateUserRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)

    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)

    @Mapping(target = "createdTasks", ignore = true)
    @Mapping(target = "assignedTasks", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "attachments", ignore = true)
    @Mapping(target = "histories", ignore = true)
    @Mapping(target = "sentNotifications", ignore = true)
    @Mapping(target = "receivedNotifications", ignore = true)
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