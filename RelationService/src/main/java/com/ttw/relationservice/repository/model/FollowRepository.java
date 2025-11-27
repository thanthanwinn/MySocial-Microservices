package com.ttw.relationservice.repository.model;

import com.ttw.relationservice.model.Follow;
import com.ttw.relationservice.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends BaseRepository<Follow,Long> {
    @Query("""
        SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END
        FROM Follow f
        WHERE f.subjectId = :followerId AND f.objectId = :followingId
    """)
    boolean existsFollow(@Param("followerId") long followerId,
                         @Param("followingId") long followingId);

    @Query("""
        SELECT f
        FROM Follow f
        WHERE f.subjectId = :followerId AND f.objectId = :followingId
    """)
    Optional<Follow> findFollow(@Param("followerId") long followerId,
                                @Param("followingId") long followingId);

    @Query("""
        SELECT f.objectId
        FROM Follow f
        WHERE f.subjectId = :followerId
    """)
    List<Long> findFollowing(@Param("followerId") long followerId);

    @Query("""
        SELECT f.subjectId
        FROM Follow f
        WHERE f.objectId = :followingId
    """)
    List<Long> findFollowers(@Param("followingId") long followingId);


}
