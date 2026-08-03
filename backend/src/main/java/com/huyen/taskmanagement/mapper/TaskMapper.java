package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.request.CreateTaskRequest;
import com.huyen.taskmanagement.dto.request.UpdateTaskRequest;
import com.huyen.taskmanagement.dto.response.TaskDetailResponse;
import com.huyen.taskmanagement.dto.response.TaskResponse;
import com.huyen.taskmanagement.entity.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignee", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "attachments", ignore = true)
    @Mapping(target = "histories", ignore = true)
    @Mapping(target = "notifications", ignore = true)
    Task toEntity(CreateTaskRequest request);

    @Mapping(target = "assigneeName",
            source = "assignee.fullName")
    TaskResponse toResponse(Task task);

    @Mapping(target = "assigneeName",
            source = "assignee.fullName")
    TaskDetailResponse toDetailResponse(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(UpdateTaskRequest request,
                                 @MappingTarget Task task);
}