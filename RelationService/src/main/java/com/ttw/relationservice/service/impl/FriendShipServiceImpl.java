package com.ttw.relationservice.service.impl;

import com.ttw.relationservice.exception.RelationException;
import com.ttw.relationservice.model.Friendship;
import com.ttw.relationservice.repository.model.FriendRepository;
import com.ttw.relationservice.service.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
@RequiredArgsConstructor
public class FriendShipServiceImpl implements FriendShipService {

    private final FriendRepository friendRepository;
    private UUID subjectId = UUID.randomUUID();

    private Friendship getFriendshipOrThrow( UUID objectId) {
        return friendRepository.findFriendship(subjectId, objectId)
                .orElseThrow(() -> new RelationException("No relation found"));
    }

    public void sendRequest( UUID objectId) {
        friendRepository.findFriendship(subjectId, objectId).ifPresent(f -> {
            throw new RelationException("Relation already exists: " + f.getStatus());
        });

        Friendship friendship = new Friendship();
        friendship.setSubject_id(subjectId);
        friendship.setObject_id(objectId);
        friendship.setStatus(Friendship.FriendshipStatus.REQUESTED);
        friendship.setCreatedAt(LocalDateTime.now());
        friendRepository.save(friendship);
    }

    public void acceptRequest( UUID objectId) {
        Friendship f = getFriendshipOrThrow( objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.REQUESTED) {
            throw new RelationException("No pending request to accept");
        }
        f.setStatus(Friendship.FriendshipStatus.ACCEPTED);
    }

    public void cancelRequest( UUID objectId) {
        Friendship f = getFriendshipOrThrow( objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.REQUESTED) {
            throw new RelationException("No pending request to cancel");
        }
        friendRepository.delete(f);
    }

    public void unfriend( UUID objectId) {
        Friendship f = getFriendshipOrThrow( objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.ACCEPTED) {
            throw new RelationException("Not friends");
        }
        friendRepository.delete(f);
    }

    public boolean areFriends(UUID subjectId, UUID objectId) {
        return friendRepository.areFriends(subjectId, objectId);
    }

    public List<UUID> getPendingRequests(UUID myId) {
        return friendRepository.findFriendRequestsSentTo(myId);
    }
}
