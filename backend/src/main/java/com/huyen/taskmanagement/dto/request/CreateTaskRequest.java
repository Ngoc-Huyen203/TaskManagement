package com.huyen.taskmanagement.dto.request;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title must not exceed 200 characters")
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

    @PositiveOrZero(message = "Estimated hours must be zero or greater")
    private Integer estimatedHours;

    @NotNull(message = "Assignee is required")
    @Positive(message = "Assignee ID must be greater than 0")
    private Long assigneeId;
}