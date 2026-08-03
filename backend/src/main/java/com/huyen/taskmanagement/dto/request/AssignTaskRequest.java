package com.huyen.taskmanagement.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AssignTaskRequest {

    @NotNull(message = "Assignee is required")
    @Positive(message = "Assignee ID must be greater than 0")
    private Long assigneeId;

}