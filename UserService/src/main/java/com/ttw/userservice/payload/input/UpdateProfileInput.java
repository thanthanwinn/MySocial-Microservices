package com.ttw.userservice.payload.input;

import com.ttw.userservice.model.User;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record UpdateProfileInput(
        @NotBlank(message = "dispaly name is required")
        String display_name,
        @NotBlank(message = " user bio is required")
        String user_bio,
        @NotBlank(message = "please upload an image")
        String user_img,
        Set<String> interests
) {
    public User model(User user){
        user.getProfile().setDisplay_name(display_name);
        user.getProfile().setUser_bio(user_bio);
        user.getProfile().setUser_img(user_img);
        user.getProfile().setInterests(interests);
        return user;
    }
}
