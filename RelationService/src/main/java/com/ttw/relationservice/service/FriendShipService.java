package com.ttw.relationservice.service;

import java.util.List;

public interface FriendShipService {
    void sendRequest(long objectId);
    void acceptRequest(long objectId);
    void cancelRequest(long objectId);
    void unfriend(long objectId);
    boolean areFriends(long subjectId, long objectId);
    List<Long> getPendingRequests(long myId);
}
