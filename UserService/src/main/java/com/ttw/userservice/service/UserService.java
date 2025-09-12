package com.ttw.userservice.service;

import com.ttw.userservice.payload.input.RegisterUserInput;
import com.ttw.userservice.payload.output.UserInfoOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface UserService {

    UserInfoOutput getUserInfo(UUID userId);

    String save(RegisterUserInput input);

}
