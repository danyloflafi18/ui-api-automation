package ui.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public final class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;
    private String postCode;
}
