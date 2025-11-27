package com.ttw.relationservice.controller;

import com.ttw.relationservice.payload.output.RelationInfoOutput;
import com.ttw.relationservice.payload.response.ApiResponse;
import com.ttw.relationservice.service.BlockService;
import com.ttw.relationservice.service.FollowService;
import com.ttw.relationservice.service.FriendShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationService;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("/api/relations")
@RequiredArgsConstructor
public class RelationController {
    private final BlockService blockService;
    private final FollowService followService;
    private final FriendShipService  friendShipService;

    @PostMapping("/block")
    public ResponseEntity<ApiResponse<String>> blockUser(@RequestParam("objectId") long objectId,@RequestParam("subjectId") long subjectId){
          blockService.block(objectId, subjectId);
          return ResponseEntity.ok(ApiResponse.success( subjectId + " blocked "+ objectId ));
    }
    @PostMapping("/unblock")
    public ResponseEntity<ApiResponse<String>> unblockUser(@RequestParam("objectId") long objectId,@RequestParam("subjectId") long subjectId){
        blockService.unblock(objectId, subjectId);
        return ResponseEntity.ok(ApiResponse.success( subjectId + " unblocked "+ objectId ));
    }
    @GetMapping("/follow")
    public ResponseEntity<ApiResponse<String>> follow(@RequestParam("objectId") long objectId,@RequestParam("subjectId") long subjectId){
        followService.follow(subjectId, objectId);
        return ResponseEntity.ok(ApiResponse.success( subjectId + " followed "+ objectId ));
    }
    @GetMapping("/unfollow")
    public ResponseEntity<ApiResponse<String>> unfollow(@RequestParam("objectId") long objectId,@RequestParam("subjectId") long subjectId) {
        followService.unfollow(subjectId, objectId);
        return ResponseEntity.ok(ApiResponse.success( subjectId + " unfollowed "+ objectId ));
    }
    @GetMapping("/getFollowings")
    public ResponseEntity<ApiResponse<List<Long>>> getFollowings(@RequestParam("userId") long userId) {
       return ResponseEntity.ok(ApiResponse.success(followService.getFollowing(userId))) ;
    }
    @GetMapping("/getFollowers")
    public ResponseEntity<ApiResponse<List<Long>>> getFollowers(@RequestParam("userId") long userId) {
        return ResponseEntity.ok(ApiResponse.success(followService.getFollowers(userId))) ;
    }
    @GetMapping("/sendFriendRequest")
    public ResponseEntity<ApiResponse<String>> sendFriendRequest(@RequestParam("subjectId") long subjectId, @RequestParam("objectId") long objectId) {
        return ResponseEntity.ok(ApiResponse.success(friendShipService.sendRequest(subjectId, objectId)));
    }
    @GetMapping("/acceptFriendRequest")
    public ResponseEntity<ApiResponse<String>> acceptFriendRequest(@RequestParam("subjectId") long subjectId, @RequestParam("objectId") long objectId) {
        return ResponseEntity.ok(ApiResponse.success(friendShipService.acceptRequest(subjectId,objectId)));
    }
    @GetMapping("/cancelFriendRequest")
    public ResponseEntity<ApiResponse<String>> cancelFriendRequest(@RequestParam("subjectId") long subjectId,  @RequestParam("objectId") long objectId) {
        return  ResponseEntity.ok(ApiResponse.success(friendShipService.acceptRequest(subjectId,objectId)));
    }
    @GetMapping("/getPendingRequests")
    public ResponseEntity<ApiResponse<List<RelationInfoOutput>>> getPendingRequests(@RequestParam("userId") long userId) {
        return ResponseEntity.ok(ApiResponse.success(friendShipService.getPendingRequests(userId)));
    }


}
