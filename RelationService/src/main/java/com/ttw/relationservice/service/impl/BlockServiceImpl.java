package com.ttw.relationservice.service.impl;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.model.BlockRepository;
import com.ttw.relationservice.service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;
    private UUID subjectId = UUID.randomUUID();

    public boolean isBlockExist(UUID objectId) {
      return   blockRepository.existsBySubjectIdAndObjectId(subjectId,objectId);
    }
    public void block(UUID objectId){
        Block block = new Block();
        block.setObject_id(objectId);
        block.setSubject_id(subjectId);
        block.setCreatedAt(LocalDateTime.now());
        blockRepository.save(block);
    }
    public void unblock(UUID objectId){
       Block block =  blockRepository.findBySubjectIdAndObjectId(subjectId,objectId);
       blockRepository.delete(block);
    }
}
