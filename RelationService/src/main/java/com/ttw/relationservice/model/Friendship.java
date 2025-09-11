package com.ttw.relationservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "friendships",
        uniqueConstraints = @UniqueConstraint(columnNames = {"requesterId", "receiverId"})
)
@Getter
@Setter
@NoArgsConstructor
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private UUID subject_id;

    private UUID object_id;;

    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;  // REQUESTED, ACCEPTED

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum FriendshipStatus {
        REQUESTED,
        ACCEPTED
    }
}
