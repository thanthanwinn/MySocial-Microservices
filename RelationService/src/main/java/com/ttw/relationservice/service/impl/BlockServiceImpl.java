package com.ttw.relationservice.service.impl;

import com.ttw.relationservice.exception.AlreadyBlockedException;
import com.ttw.relationservice.model.Block;
import com.ttw.relationservice.repository.model.BlockRepository;
import com.ttw.relationservice.service.BlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;

    @Override
    public boolean isBlockExist(long objectId, long subjectId) {
      return   blockRepository.existsBySubjectIdAndObjectId(subjectId,objectId);
    }


    public void block(long objectId, long subjectId) {
        if(isBlockExist(objectId,subjectId)) {
            throw new AlreadyBlockedException(List.of("this user is blocked"));
        }
        Block block = new Block();
        block.setObjectId(objectId);
        block.setSubjectId(subjectId);
        block.setCreatedAt(LocalDateTime.now());
        blockRepository.save(block);
    }
    public void unblock(long objectId, long subjectId) {
       Block block =  blockRepository.findBySubjectIdAndObjectId(subjectId,objectId);
       blockRepository.delete(block);
    }
}
