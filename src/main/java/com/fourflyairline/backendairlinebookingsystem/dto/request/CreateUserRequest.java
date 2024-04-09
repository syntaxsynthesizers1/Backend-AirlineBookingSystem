package com.fourflyairline.backendairlinebookingsystem.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateUserRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    private String dob;
    private String nic;
}
