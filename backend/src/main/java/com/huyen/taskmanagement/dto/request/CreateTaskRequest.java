package com.huyen.taskmanagement.dto.request;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Priority is required")
    private TaskPriority priority;

    @NotNull(message = "Status is required")
    private TaskStatus status;

    @FutureOrPresent(message = "Start date must be today or later")
    private LocalDate startDate;

    @FutureOrPresent(message = "Due date must be today or later")
    private LocalDate dueDate;

    private Integer estimatedHours;

    @NotNull(message = "Assignee is required")
    private Long assigneeId;
}