package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.request.AddCommentRequest;
import com.huyen.taskmanagement.dto.request.UpdateCommentRequest;
import com.huyen.taskmanagement.dto.response.CommentResponse;
import com.huyen.taskmanagement.entity.TaskComment;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        builder = @Builder(disableBuilder = true)
)
public interface TaskCommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "task", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    TaskComment toEntity(AddCommentRequest request);

    @Mapping(target = "authorName", source = "user.fullName")
    CommentResponse toResponse(TaskComment comment);

    @Mapping(target = "id", ignore = true)

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)

    @Mapping(target = "task", ignore = true)
    @Mapping(target = "user", ignore = true)
    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(
            UpdateCommentRequest request,
            @MappingTarget TaskComment comment
    );

}