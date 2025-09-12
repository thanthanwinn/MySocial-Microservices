package com.ttw.relationservice.repository.model;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.BaseRepository;

import java.util.UUID;

public interface BlockRepository extends BaseRepository<Block, Long> {

    boolean existsBySubjectIdAndObjectId(UUID subjectId, UUID objectId);

}
