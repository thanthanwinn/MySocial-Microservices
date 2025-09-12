package com.ttw.relationservice.repository.model;

import com.ttw.relationservice.model.Follow;
import com.ttw.relationservice.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FollowRepository extends BaseRepository<Follow,Long> {
    @Query("""
        SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END
        FROM Follow f
        WHERE f.subject_id = :followerId AND f.object_id = :followingId
    """)
    boolean existsFollow(@Param("followerId") UUID followerId,
                         @Param("followingId") UUID followingId);

    @Query("""
        SELECT f
        FROM Follow f
        WHERE f.subject_id = :followerId AND f.object_id = :followingId
    """)
    Optional<Follow> findFollow(@Param("followerId") UUID followerId,
                                @Param("followingId") UUID followingId);

    @Query("""
        SELECT f.object_id
        FROM Follow f
        WHERE f.subject_id = :followerId
    """)
    List<UUID> findFollowing(@Param("followerId") UUID followerId);

    @Query("""
        SELECT f.subject_id
        FROM Follow f
        WHERE f.object_id = :followingId
    """)
    List<UUID> findFollowers(@Param("followingId") UUID followingId);


}
