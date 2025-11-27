package com.ttw.relationservice.service;


import com.ttw.relationservice.payload.output.RelationInfoOutput;

import java.util.List;

public interface FriendShipService {
    String sendRequest(long subjectId,long objectId);
    String acceptRequest(long subjectId,long objectId);
    String cancelRequest(long subjectId,long objectId);
    String unfriend(long subjectId,long objectId);
    boolean areFriends(long subjectId, long objectId);
    List<RelationInfoOutput> getPendingRequests(long myId);
}
