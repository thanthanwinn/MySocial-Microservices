package com.ttw.relationservice.service;
import java.util.List;
import java.util.UUID;

public interface FollowService {
    void follow(UUID objectId);
    void unfollow(UUID objectId);
    boolean isFollowing(UUID objectId);
    List<UUID> getFollowers(UUID userId);
    List<UUID> getFollowing(UUID userId);
}
