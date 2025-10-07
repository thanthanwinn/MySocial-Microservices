package com.ttw.relationservice.service.impl;

import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.model.BlockRepository;
import com.ttw.relationservice.service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;
    long subjectId = 0;

    @Override
    public boolean isBlockExist(long objectId) {
        return   blockRepository.existsBySubjectIdAndObjectId(subjectId,objectId);

    }

    @Override
    public boolean isBlockExist(long objectId, long subjectId) {
      return   blockRepository.existsBySubjectIdAndObjectId(subjectId,objectId);
    }


    public void block(long objectId){
        Block block = new Block();
        block.setObjectId(objectId);
        block.setSubjectId(subjectId);
        block.setCreatedAt(LocalDateTime.now());
        blockRepository.save(block);
    }
    public void unblock(long objectId){
       Block block =  blockRepository.findBySubjectIdAndObjectId(subjectId,objectId);
       blockRepository.delete(block);
    }
}
