package com.ttw.relationservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity

public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID subject_id;

    private UUID object_id;

    private LocalDateTime createdAt = LocalDateTime.now();
}
