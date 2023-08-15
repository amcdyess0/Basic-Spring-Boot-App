package com.website.website.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AccountInfo {

    private String username;
    private String password;
    private String creationDate;
    private String accountStatus;

    public AccountInfo(String username, String password, String accountStatus) {
        this.username = username;
        this.password = password;
        this.creationDate = LocalDateTime.now().toString();
        this.accountStatus = accountStatus;
    }


}
