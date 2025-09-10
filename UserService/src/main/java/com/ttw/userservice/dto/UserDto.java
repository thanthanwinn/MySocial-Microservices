package com.ttw.userservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private String user_id;
    private String user_name;
    private String user_email;
    private ProfileDto profile;


}
