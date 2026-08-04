package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.response.AttachmentResponse;
import com.huyen.taskmanagement.entity.TaskAttachment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskAttachmentMapper {

    @Mapping(target = "uploadedByName", source = "uploadedBy.fullName")
    AttachmentResponse toResponse(TaskAttachment attachment);

}