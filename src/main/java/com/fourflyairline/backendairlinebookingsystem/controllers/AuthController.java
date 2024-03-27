package com.fourflyairline.backendairlinebookingsystem.controllers;



import com.fourflyairline.backendairlinebookingsystem.dto.request.AuthRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.ForgotPasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.response.AuthResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.ValidateResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.CollegeCourseRegistrationException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;
import com.fourflyairline.backendairlinebookingsystem.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest request) throws CollegeCourseRegistrationException {
        return ResponseEntity.status(HttpStatus.OK).body(authService.register(request));
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<Response> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) throws CollegeCourseRegistrationException {
        return ResponseEntity.status(HttpStatus.OK).body(authService.forgotPassword(forgotPasswordRequest));
    }




    @GetMapping("/verifyEmail")
    public ValidateResponse verifyEmail(@RequestParam("token") String token) throws CollegeCourseRegistrationException {
        return authService.verify(token);
    }

}
