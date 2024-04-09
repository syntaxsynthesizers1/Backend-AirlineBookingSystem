package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.AuthRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.ForgotPasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.response.AuthResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.ValidateResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;

public interface AuthService {
    AuthResponse register(AuthRequest registerRequest) throws AirlineBookingSystemException;

    ValidateResponse verify(String token) throws AirlineBookingSystemException;
    Response forgotPassword (ForgotPasswordRequest forgotPasswordRequest) throws AirlineBookingSystemException;


}
