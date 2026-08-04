package com.huyen.taskmanagement.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskHistoryResponse {

    private Long id;

    private String action;

    private String fieldName;

    private String oldValue;

    private String newValue;

    private String userName;

    private LocalDateTime createdAt;

}
