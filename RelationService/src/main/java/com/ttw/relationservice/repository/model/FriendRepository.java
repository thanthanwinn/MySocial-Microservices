package com.ttw.relationservice.repository.model;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.model.Friendship;
import com.ttw.relationservice.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface FriendRepository extends BaseRepository<Friendship,Long> {


    @Query("""
        SELECT f FROM Friendship f
        WHERE ((f.subject_id = :user1 AND f.object_id = :user2)
            OR (f.subject_id = :user2 AND f.object_id = :user1))
    """)
    Optional<Friendship> findFriendship(@Param("user1") long user1,
                                        @Param("user2") long user2);

    @Query("""
        SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END
        FROM Friendship f
        WHERE ((f.subject_id = :user1 AND f.object_id = :user2)
            OR (f.subject_id = :user2 AND f.object_id = :user1))
        AND f.status = 'ACCEPTED'
    """)
    boolean areFriends(@Param("user1") long user1, @Param("user2") long user2);

    @Query("""
        SELECT f.subject_id
        FROM Friendship f
        WHERE f.object_id = :receiverId
          AND f.status = 'REQUESTED'
    """)
    List<Long> findFriendRequestsSentTo(@Param("receiverId") long receiverId);



}
