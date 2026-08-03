package com.huyen.taskmanagement.dto.request;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTaskRequest {

    @Size(max = 200, message = "Title must not exceed 200 characters")
    private String title;

    private String description;

    private TaskPriority priority;

    private TaskStatus status;

    private LocalDate startDate;

    private LocalDate dueDate;

    @PositiveOrZero(message = "Estimated hours must be zero or greater")
    private Integer estimatedHours;

    @PositiveOrZero(message = "Actual hours must be zero or greater")
    private Integer actualHours;
}