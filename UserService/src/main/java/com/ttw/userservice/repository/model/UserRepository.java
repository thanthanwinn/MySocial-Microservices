package com.ttw.userservice.repository.model;

import com.ttw.userservice.model.User;
import com.ttw.userservice.repository.BaseRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends BaseRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByEmail(String email);
}
