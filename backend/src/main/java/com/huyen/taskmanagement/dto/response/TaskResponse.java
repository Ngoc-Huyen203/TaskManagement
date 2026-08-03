package com.huyen.taskmanagement.dto.response;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskResponse {

    private Long id;

    private String title;

    private TaskStatus status;

    private TaskPriority priority;

    private String assigneeName;

    private LocalDate dueDate;

}