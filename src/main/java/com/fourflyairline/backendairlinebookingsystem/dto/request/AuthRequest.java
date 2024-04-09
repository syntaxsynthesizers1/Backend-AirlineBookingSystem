package com.fourflyairline.backendairlinebookingsystem.dto.request;


import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class AuthRequest {
    @Email(message = "invalid email address",regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    private String email;
    private String password;
    private String firstName;
    private String lastName;
   private String gender;
    private String phoneNumber;
   private String dob;
   private String nic;
}
