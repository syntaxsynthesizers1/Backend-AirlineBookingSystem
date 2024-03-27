package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.AuthRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.ForgotPasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.response.AuthResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.ValidateResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.CollegeCourseRegistrationException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;

public interface AuthService {
    AuthResponse register(AuthRequest registerRequest) throws CollegeCourseRegistrationException;

    ValidateResponse verify(String token) throws CollegeCourseRegistrationException;
    Response forgotPassword (ForgotPasswordRequest forgotPasswordRequest) throws CollegeCourseRegistrationException;


}
