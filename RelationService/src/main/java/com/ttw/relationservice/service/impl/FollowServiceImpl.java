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

@Service
@Transactional
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;
    private long subjectId = 0;
    @Override
    public void follow(long subjectId, long objectId) {
        if (subjectId == objectId) {
            throw new RelationException("You cannot follow yourself");
        }
        if (followRepository.existsFollow(subjectId, objectId)) {
            throw new RelationException("Already following this user");
        }

        Follow follow = new Follow();
        follow.setSubjectId(subjectId);
        follow.setObjectId(objectId);
        follow.setCreatedAt(LocalDateTime.now());
        followRepository.save(follow);
    }

    @Override
    public void unfollow(long subjectId, long objectId) {
        Follow follow = followRepository.findFollow(subjectId, objectId)
                .orElseThrow(() -> new RelationException("Not following this user"));
        followRepository.delete(follow);
    }

    @Override
    public boolean isFollowing(long subjectId, long objectId) {
        return followRepository.existsFollow(subjectId, objectId);
    }


    public List<Long> getFollowers(long userId) {
        return followRepository.findFollowers(userId);
    }

    public List<Long> getFollowing(long userId) {
        return followRepository.findFollowing(userId);
    }
}
