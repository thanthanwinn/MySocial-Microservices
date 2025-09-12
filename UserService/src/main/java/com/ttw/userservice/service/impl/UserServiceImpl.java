package com.ttw.userservice.service.impl;

import com.ttw.userservice.exception.UserBusinessException;
import com.ttw.userservice.model.User;
import com.ttw.userservice.payload.input.RegisterUserInput;
import com.ttw.userservice.payload.output.UserInfoOutput;
import com.ttw.userservice.repository.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements com.ttw.userservice.service.UserService {

    private final UserRepository userRepository;

    @Override
    public UserInfoOutput getUserInfo(UUID userId) {

        User user = userRepository.findById(userId).orElseThrow();
        return UserInfoOutput.from(user);
    }

    @Override
    public String save(RegisterUserInput input) {
        User user = input.model();
        if (userRepository.findUserByUsername(user.getUsername())) {
            throw  new UserBusinessException("Username is already taken");
        }
        if (userRepository.findUserByEmail(user.getEmail())) {
            throw new UserBusinessException("email address is already taken");
        }

        userRepository.save(user);

        return "User registered successfully";

    }
}
