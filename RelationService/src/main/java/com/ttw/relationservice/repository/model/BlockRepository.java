package com.ttw.relationservice.repository.model;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.BaseRepository;



public interface BlockRepository extends BaseRepository<Block, Long> {

    boolean existsBySubjectIdAndObjectId(long subjectId, long objectId);

    Block findBySubjectIdAndObjectId(long subjectId, long objectId);


}
