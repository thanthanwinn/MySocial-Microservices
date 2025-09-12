package com.ttw.userservice.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;


@Embeddable
@Getter
@Setter
@Table(name= "user_profile" )
public class Profile {

    private String display_name;
    private String user_bio;
    private String user_img;
    @ElementCollection
    @CollectionTable(name = "user_interests")
    private Set<String> interests = new HashSet<String>();


}
