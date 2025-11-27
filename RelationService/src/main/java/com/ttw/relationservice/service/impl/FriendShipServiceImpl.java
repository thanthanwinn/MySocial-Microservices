package com.ttw.relationservice.service.impl;

import com.ttw.relationservice.exception.RelationException;
import com.ttw.relationservice.model.Friendship;
import com.ttw.relationservice.payload.output.RelationInfoOutput;
import com.ttw.relationservice.repository.model.FriendRepository;
import com.ttw.relationservice.service.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class FriendShipServiceImpl implements FriendShipService {

    private final FriendRepository friendRepository;

    private Friendship getFriendshipOrThrow( long subjectId,long objectId) {
        return friendRepository.findFriendship(subjectId, objectId)
                .orElseThrow(() -> new RelationException("No relation found"));
    }

    public String sendRequest( long subjectId,long objectId) {
        friendRepository.findFriendship(subjectId, objectId).ifPresent(f -> {
            throw new RelationException("Relation already exists: " + f.getStatus());
        });

        Friendship friendship = new Friendship();
        friendship.setSubjectId(subjectId);
        friendship.setObjectId(objectId);
        friendship.setStatus(Friendship.FriendshipStatus.REQUESTED);
        friendship.setCreatedAt(LocalDateTime.now());
        friendRepository.save(friendship);
        return  subjectId + "send friend request to" + objectId;
    }

    public String acceptRequest( long subjectId,long objectId) {
        Friendship f = getFriendshipOrThrow( subjectId,objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.REQUESTED) {
            throw new RelationException("No pending request to accept");
        }
        f.setStatus(Friendship.FriendshipStatus.ACCEPTED);
        return  subjectId + "accept friend request to" + objectId;

    }

    public String cancelRequest( long subjectId,long objectId) {
        Friendship f = getFriendshipOrThrow( subjectId,objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.REQUESTED) {
            throw new RelationException("No pending request to cancel");
        }
        friendRepository.delete(f);
        return  subjectId + "cancel friend request to" + objectId;

    }

    public String unfriend( long subjectId,long objectId) {
        Friendship f = getFriendshipOrThrow( subjectId,objectId);
        if (f.getStatus() != Friendship.FriendshipStatus.ACCEPTED) {
            throw new RelationException("Not friends");
        }
        friendRepository.delete(f);
        return  subjectId + "send friend request to" + objectId;
    }

    public boolean areFriends(long subjectId, long objectId) {
        return friendRepository.areFriends(subjectId, objectId);
    }


    public List<RelationInfoOutput> getPendingRequests(long myId) {
        List<Friendship>  pendingRequests = friendRepository.findFriendRequestsSentTo(myId);
        return  pendingRequests.stream()
                .map(obj -> RelationInfoOutput.from(obj))
                .collect(Collectors.toList());
    }
}
