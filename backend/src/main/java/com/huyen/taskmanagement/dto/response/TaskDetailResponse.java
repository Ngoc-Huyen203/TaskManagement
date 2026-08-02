package com.huyen.taskmanagement.dto.response;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskDetailResponse {

    private Long id;

    private String title;

    private String description;

    private TaskStatus status;

    private TaskPriority priority;

    private String assigneeName;

    private LocalDate startDate;

    private LocalDate dueDate;

    private Integer estimatedHours;

    private Integer actualHours;

    private List<CommentResponse> comments;

    private List<AttachmentResponse> attachments;

    private List<TaskHistoryResponse> history;

}