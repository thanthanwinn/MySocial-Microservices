package com.ttw.relationservice.service;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.model.BlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

public interface BlockService {
    boolean isBlockExist(UUID objectId);
    void block(UUID objectId);
     void unblock(UUID objectId);
}
