package com.ttw.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class ProfileDto {
    private String display_name;
    private String user_bio;
    private String user_img;
    private Set<String> interests;

}
