package com.huyen.taskmanagement.dto.request;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateTaskRequest {

    private String title;

    private String description;

    private TaskPriority priority;

    private TaskStatus status;

    private LocalDate startDate;

    private LocalDate dueDate;

    private Integer estimatedHours;

    private Integer actualHours;
}