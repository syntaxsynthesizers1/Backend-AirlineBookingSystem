package com.fourflyairline.backendairlinebookingsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgotPasswordRequest {
    private String newPassword;
    private String email;
}
