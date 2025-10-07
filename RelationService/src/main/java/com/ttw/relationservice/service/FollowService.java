package com.ttw.relationservice.service;
import java.util.List;

public interface FollowService {
    void follow(long objectId);
    void unfollow(long objectId);
    boolean isFollowing(long objectId);
    List<Long> getFollowers(long userId);
    List<Long> getFollowing(long userId);
}
