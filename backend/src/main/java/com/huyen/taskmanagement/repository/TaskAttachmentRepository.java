package com.huyen.taskmanagement.repository;

import com.huyen.taskmanagement.entity.Task;
import com.huyen.taskmanagement.entity.TaskAttachment;
import com.huyen.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskAttachmentRepository extends JpaRepository<TaskAttachment, Long> {

    List<TaskAttachment> findByTask(Task task);

    List<TaskAttachment> findByTaskId(Long taskId);

    List<TaskAttachment> findByTaskIdAndDeletedFalse(Long taskId);

    List<TaskAttachment> findByUser(User user);

    List<TaskAttachment> findByUserId(Long userId);

    Optional<TaskAttachment> findByIdAndDeletedFalse(Long id);

    long countByTaskId(Long taskId);

}
