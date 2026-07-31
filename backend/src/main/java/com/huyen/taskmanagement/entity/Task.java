package com.huyen.taskmanagement.entity;

import com.huyen.taskmanagement.enums.TaskPriority;
import com.huyen.taskmanagement.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(
        name = "tasks",
        indexes = {
                @Index(name = "idx_task_status", columnList = "status"),
                @Index(name = "idx_task_priority", columnList = "priority"),
                @Index(name = "idx_task_due_date", columnList = "due_date"),
                @Index(name = "idx_task_assignee", columnList = "assignee_id")
        }
)
public class Task extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskPriority priority;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Column(name = "completed_date")
    private LocalDate completedDate;

    @Column(name = "estimated_hours")
    private Integer estimatedHours;

    @Column(name = "actual_hours")
    private Integer actualHours;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "creator_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_task_creator")
    )
    private User creator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "assignee_id",
            foreignKey = @ForeignKey(name = "fk_task_assignee")
    )
    private User assignee;

    @Builder.Default
    @OneToMany(mappedBy = "task",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<TaskComment> comments = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "task",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<TaskAttachment> attachments = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "task",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<TaskHistory> histories = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "task",
            fetch = FetchType.LAZY)
    private Set<Notification> notifications = new HashSet<>();
}