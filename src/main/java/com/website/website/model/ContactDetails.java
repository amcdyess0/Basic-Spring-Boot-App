package com.website.website.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ContactDetails {

    private String billingAddress;
    private String shippingAddress;
    private String preferredCommunication;
}
