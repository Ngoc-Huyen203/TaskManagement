package com.huyen.taskmanagement.dto.response;

import com.huyen.taskmanagement.enums.NotificationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {

    private Long id;

    private String title;

    private String message;

    private NotificationType type;

    private Boolean isRead;

    private Long taskId;

    private String senderName;

    private LocalDateTime createdAt;

}