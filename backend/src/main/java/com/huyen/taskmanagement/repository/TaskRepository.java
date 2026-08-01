package com.huyen.taskmanagement.repository;


import com.huyen.taskmanagement.entity.Task;
import com.huyen.taskmanagement.entity.User;
import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDeletedFalse();

    List<Task> findByAssignee(User assignee);

    List<Task> findByCreator(User creator);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByPriority(TaskPriority priority);

    List<Task> findByTitleContainingIgnoreCase(String keyword);

    List<Task> findByDueDateBefore(LocalDate dueDate);

    List<Task> findByStatusAndDeletedFalse(TaskStatus status);

    List<Task> findByAssigneeAndDeletedFalse(User assignee);

    long countByDeletedFalse();

    long countByStatus(TaskStatus status);

    long countByAssignee(User assignee);

}
