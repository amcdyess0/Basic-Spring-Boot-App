package com.website.website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@Document(collection = "")
public class User {
    @Id
    @Field(name = "_id")
    private ObjectId id;

    private String userId;
    private PersonalInfo personalInfo;
    private ContactDetails contactDetails;
    private AccountInfo accountInfo;

    public User(PersonalInfo personalInfo, ContactDetails contactDetails, AccountInfo accountInfo) {
        this.id = new ObjectId();
        this.userId = id.toString();
        this.personalInfo = personalInfo;
        this.contactDetails = contactDetails;
        this.accountInfo = accountInfo;
    }
}
