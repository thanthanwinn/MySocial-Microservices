package com.ttw.userservice.service;

import com.ttw.userservice.exception.UserBusinessException;
import com.ttw.userservice.model.User;
import com.ttw.userservice.payload.input.RegisterUserInput;
import com.ttw.userservice.payload.input.UpdateProfileInput;
import com.ttw.userservice.payload.output.UserInfoOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface UserService {


    UserInfoOutput getUserInfo(Long userId);

    User save(RegisterUserInput input);

    UserInfoOutput updateProfile(Long userId, UpdateProfileInput input);
}