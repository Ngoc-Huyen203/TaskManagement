package com.huyen.taskmanagement.repository;

import com.huyen.taskmanagement.entity.Notification;
import com.huyen.taskmanagement.entity.User;
import com.huyen.taskmanagement.enums.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByReceiver(User receiver);

    List<Notification> findByReceiverId(Long receiverId);

    List<Notification> findByReceiverIdAndDeletedFalse(Long receiverId);

    List<Notification> findByReceiverIdAndIsReadFalseOrderByCreatedAtDesc(Long receiverId);

    List<Notification> findByReceiverIdOrderByCreatedAtDesc(Long receiverId);

    List<Notification> findByReceiverIdAndType(Long receiverId, NotificationType type);

    long countByReceiverId(Long receiverId);

    long countByReceiverIdAndIsReadFalse(Long receiverId);

}
