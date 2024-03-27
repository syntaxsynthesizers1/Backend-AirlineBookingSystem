package com.fourflyairline.backendairlinebookingsystem.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResetPasswordRequest {
    private String code;
    private String newPassword;


}
