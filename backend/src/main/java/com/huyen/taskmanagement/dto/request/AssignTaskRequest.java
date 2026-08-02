package com.huyen.taskmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AssignTaskRequest {

    @NotNull(message = "Assignee is required")
    private Long assigneeId;

}