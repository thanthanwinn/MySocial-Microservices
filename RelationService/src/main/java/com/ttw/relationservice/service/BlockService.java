package com.ttw.relationservice.service;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.model.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public interface BlockService {

    boolean isBlockExist(long objectId, long subjectId);

    void block(long objectId, long subjectId);
     void unblock(long objectId,  long subjectId);
}
