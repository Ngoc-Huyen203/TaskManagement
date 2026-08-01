package com.huyen.taskmanagement.repository;

import com.huyen.taskmanagement.entity.Task;
import com.huyen.taskmanagement.entity.TaskComment;
import com.huyen.taskmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {

    List<TaskComment> findByTask(Task task);

    List<TaskComment> findByTaskId(Long taskId);

    List<TaskComment> findByTaskIdAndDeletedFalse(Long taskId);

    List<TaskComment> findByUser(User user);

    List<TaskComment> findByUserId(Long userId);

    long countByTaskId(Long taskId);

}
