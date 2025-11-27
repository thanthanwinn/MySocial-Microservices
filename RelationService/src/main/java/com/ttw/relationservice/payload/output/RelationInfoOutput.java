package com.ttw.relationservice.payload.output;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.model.Follow;
import com.ttw.relationservice.model.Friendship;

import java.time.format.DateTimeFormatter;


public record RelationInfoOutput(
    long id,
    long subjectId,
    long objectId,
    String friendShipStatus,
    String createAt
) {

    public static RelationInfoOutput from(Block input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new RelationInfoOutput(
                input.getId(),
                input.getSubjectId(),
                input.getObjectId(),
                null,
                input.getCreatedAt().format(formatter)
        );
    }

    public static RelationInfoOutput from(Friendship input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new RelationInfoOutput(
                input.getId(),
                input.getSubjectId(),
                input.getObjectId(),
                input.getStatus().toString(),
                input.getCreatedAt().format(formatter)
        );
    }

    public static RelationInfoOutput from(Follow input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return new RelationInfoOutput(
                input.getId(),
                input.getSubjectId(),
                input.getObjectId(),
                null,
                input.getCreatedAt().format(formatter)
        );
    }

}
