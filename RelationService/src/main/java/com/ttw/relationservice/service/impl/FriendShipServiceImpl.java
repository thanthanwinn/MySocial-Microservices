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



@Service
@Transactional
@RequiredArgsConstructor
public class FriendShipServiceImpl implements FriendShipService {

    private final FriendRepository friendRepository;
    private long subjectId = 0;

    private Friendship getFriendshipOrThrow( long objectId) {
        return friendRepository.findFriendship(subjectId, objectId)
                .orElseThrow(() -> new RelationException("No relation found"));
    }

    public void sendRequest( long objectId) {
        friendRepository.findFriendship(subjectId, objectId).ifPresent(f -> {
            throw new RelationException("Relation already exists: " + f.getStatus());
        });

        Friendship friendship = new Friendship();
        friendship.setSubjectId(subjectId);
        friendship.setObjectId(objectId);
        friendship.setStatus(Friendship.FriendshipStatus.REQUESTED);
        friendship.setCreatedAt(LocalDateTime.now());
        friendRepository.save(friendship);
    }

    public void acceptRequest( long objectId) {
        Friendship f = getFriendshipOrThrow( objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.REQUESTED) {
            throw new RelationException("No pending request to accept");
        }
        f.setStatus(Friendship.FriendshipStatus.ACCEPTED);
    }

    public void cancelRequest( long objectId) {
        Friendship f = getFriendshipOrThrow( objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.REQUESTED) {
            throw new RelationException("No pending request to cancel");
        }
        friendRepository.delete(f);
    }

    public void unfriend( long objectId) {
        Friendship f = getFriendshipOrThrow( objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.ACCEPTED) {
            throw new RelationException("Not friends");
        }
        friendRepository.delete(f);
    }

    public boolean areFriends(long subjectId, long objectId) {
        return friendRepository.areFriends(subjectId, objectId);
    }

    public List<Long> getPendingRequests(long myId) {
        return friendRepository.findFriendRequestsSentTo(myId);
    }
}
