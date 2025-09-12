package com.ttw.relationservice.service.impl;

import com.ttw.relationservice.exception.RelationException;
import com.ttw.relationservice.model.Follow;
import com.ttw.relationservice.repository.model.FollowRepository;
import com.ttw.relationservice.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    private UUID subjectId = UUID.randomUUID();

    public void follow( UUID objectId) {
        if (subjectId.equals(objectId)) {
            throw new RelationException("You cannot follow yourself");
        }
        if (followRepository.existsFollow(subjectId, objectId)) {
            throw new RelationException("Already following this user");
        }

        Follow follow = new Follow();
        follow.setSubject_id(subjectId);
        follow.setObject_id(objectId);
        follow.setCreatedAt(LocalDateTime.now());
        followRepository.save(follow);
    }

    public void unfollow( UUID objectId) {
        Follow follow = followRepository.findFollow(subjectId, objectId)
                .orElseThrow(() -> new RelationException("Not following this user"));
        followRepository.delete(follow);
    }

    public boolean isFollowing(UUID objectId) {
        return followRepository.existsFollow(subjectId, objectId);
    }

    public List<UUID> getFollowers(UUID userId) {
        return followRepository.findFollowers(userId);
    }

    public List<UUID> getFollowing(UUID userId) {
        return followRepository.findFollowing(userId);
    }
}
