package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.response.NotificationResponse;
import com.huyen.taskmanagement.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(target = "senderName", source = "sender.fullName")
    @Mapping(target = "taskId", source = "task.id")
    NotificationResponse toResponse(Notification notification);

}