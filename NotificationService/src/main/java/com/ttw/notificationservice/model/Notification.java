package com.ttw.notificationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID notification_id;
    private UUID subject_UUID;
    private UUID receiver_UUID;
    private String notification_type;
    private String content;
    private UUID model_UUID;
    private boolean isRead = false;
    private LocalDateTime createdAt = LocalDateTime.now();
}
