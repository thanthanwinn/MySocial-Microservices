package com.ttw.relationservice.service;
import java.util.List;

public interface FollowService {
    void follow(long subjectId,long objectId);
    void unfollow(long subjectId,long objectId);
    boolean isFollowing(long subjectId,long objectId);
    List<Long> getFollowers(long userId);
    List<Long> getFollowing(long userId);
}
