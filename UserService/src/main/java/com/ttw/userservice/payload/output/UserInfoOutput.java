package com.ttw.userservice.payload.output;

import com.ttw.userservice.model.User;
import lombok.Data;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

public record UserInfoOutput(
        long user_id,
        String username,
        String email,
        Integer age,
        String display_name,
        String user_bio,
        String user_img,
        Set<String> interests

) {
    public static UserInfoOutput from(User user){
        return new UserInfoOutput(
                user.getUser_id(),
                user.getUsername(),
                user.getEmail(),
                user.getAge(),
                user.getProfile().getDisplay_name(),
                user.getProfile().getUser_bio(),
                user.getProfile().getUser_img(),
                user.getProfile().getInterests()
        );
    }

}
