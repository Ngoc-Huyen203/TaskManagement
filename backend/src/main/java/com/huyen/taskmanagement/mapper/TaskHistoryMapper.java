package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.response.TaskHistoryResponse;
import com.huyen.taskmanagement.entity.TaskHistory;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskHistoryMapper {

    @Mapping(target = "action",
            expression = "java(history.getAction().name())")
    @Mapping(target = "userName",
            source = "user.fullName")
    TaskHistoryResponse toResponse(TaskHistory history);

    List<TaskHistoryResponse> toResponseList(List<TaskHistory> histories);
}
