package com.ttw.userservice.repository.model;

import com.ttw.userservice.model.User;
import com.ttw.userservice.repository.BaseRepository;

import java.util.UUID;

public interface UserRepository extends BaseRepository<User, UUID> {
    boolean findUserByUsername(String username);

    boolean findUserByEmail(String email);
}
