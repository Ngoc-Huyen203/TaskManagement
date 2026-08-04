package com.huyen.taskmanagement.mapper;

import com.huyen.taskmanagement.dto.request.AddCommentRequest;
import com.huyen.taskmanagement.dto.request.UpdateCommentRequest;
import com.huyen.taskmanagement.dto.response.CommentResponse;
import com.huyen.taskmanagement.entity.TaskComment;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskCommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "task", ignore = true)
    @Mapping(target = "user", ignore = true)
    TaskComment toEntity(AddCommentRequest request);

    @Mapping(target = "authorName",
            expression = "java(comment.getUser().getFullName())")
    CommentResponse toResponse(TaskComment comment);

    @BeanMapping(
            nullValuePropertyMappingStrategy =
                    NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(
            UpdateCommentRequest request,
            @MappingTarget TaskComment comment
    );

}