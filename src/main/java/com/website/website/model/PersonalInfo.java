package com.website.website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PersonalInfo {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @Field(name = "Date of Birth")
    private String DOB;
}
