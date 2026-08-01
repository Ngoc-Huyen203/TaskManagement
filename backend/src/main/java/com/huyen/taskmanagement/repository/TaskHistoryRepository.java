package com.huyen.taskmanagement.repository;

import com.huyen.taskmanagement.entity.Task;
import com.huyen.taskmanagement.entity.TaskHistory;
import com.huyen.taskmanagement.entity.User;
import com.huyen.taskmanagement.enums.HistoryAction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {

    List<TaskHistory> findByTask(Task task);

    List<TaskHistory> findByTaskId(Long taskId);

    List<TaskHistory> findByTaskIdAndDeletedFalseOrderByCreatedAtDesc(Long taskId);

    List<TaskHistory> findByUser(User user);

    List<TaskHistory> findByUserId(Long userId);

    List<TaskHistory> findByAction(HistoryAction action);

    List<TaskHistory> findByTaskIdAndAction(Long taskId, HistoryAction action);

    long countByTaskId(Long taskId);

}
