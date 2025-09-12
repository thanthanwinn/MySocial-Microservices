package com.ttw.relationservice.service;

import java.util.List;
import java.util.UUID;

public interface FriendShipService {
    void sendRequest(UUID objectId);
    void acceptRequest(UUID objectId);
    void cancelRequest(UUID objectId);
    void unfriend(UUID objectId);
    boolean areFriends(UUID subjectId, UUID objectId);
    List<UUID> getPendingRequests(UUID myId);
}
