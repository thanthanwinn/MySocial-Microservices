package com.ttw.userservice.service.impl;

import com.ttw.userservice.exception.UserBusinessException;
import com.ttw.userservice.model.User;
import com.ttw.userservice.payload.input.RegisterUserInput;
import com.ttw.userservice.payload.input.UpdateProfileInput;
import com.ttw.userservice.payload.output.UserInfoOutput;
import com.ttw.userservice.repository.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements com.ttw.userservice.service.UserService {

    private final UserRepository userRepository;

    @Override
    public UserInfoOutput getUserInfo(Long userId) {

        User user = userRepository.findById(userId).orElseThrow();
        return UserInfoOutput.from(user);
    }

    @Override
    public User save(RegisterUserInput input) {
        User user = input.model(input);
       if (userRepository.findUserByUsername(user.getUsername()).toString() == input.username().toString()) {

            throw  new UserBusinessException("Username is already taken");
       }
//        if (userRepository.findUserByEmail(user.getEmail()) != null) {
//            throw new UserBusinessException("email address is already taken");
//        }
        System.out.println(input.username() + input.email() + input.age());

        User savedUser =  userRepository.save(user);

       // return "User registered successfully";
        return savedUser;

    }
@Override
public UserInfoOutput updateProfile(Long userId, UpdateProfileInput input) throws UserBusinessException {
        User user = userRepository.findById(userId).orElseThrow(()->  new UserBusinessException("user not found with this id"));
        user.getProfile().setUser_bio(input.user_bio());
        user.getProfile().setUser_img(input.user_img());
        user.getProfile().setDisplay_name(input.display_name());
        user.getProfile().setInterests(input.interests());
        return UserInfoOutput.from(user);
    }
}
