package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.AuthRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.CreateUserRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.ForgotPasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.response.AuthResponse;
import com.fourflyairline.backendairlinebookingsystem.dto.response.ValidateResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;
import com.fourflyairline.backendairlinebookingsystem.mail.CollegeCourseEmailService;
import com.fourflyairline.backendairlinebookingsystem.mail.EmailRequest;
import com.fourflyairline.backendairlinebookingsystem.model.User;
import com.fourflyairline.backendairlinebookingsystem.model.VerificationToken;
import com.fourflyairline.backendairlinebookingsystem.repositories.VerificationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static com.fourflyairline.backendairlinebookingsystem.model.Authority.USER;


@Slf4j
@Service
@AllArgsConstructor
public class AirlineBookingAuthService implements AuthService {

    private final CollegeCourseEmailService mailService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final VerificationTokenRepository tokenRepository;


    @Override
    public AuthResponse register(AuthRequest registerRequest) throws AirlineBookingSystemException {

        CreateUserRequest createUserRequest = modelMapper.map(registerRequest, CreateUserRequest.class);
        User user = userService.createUser(createUserRequest);

        user.setAuthorities(List.of(USER));
        initiateUserVerificationEmail(user.getEmail());
        return new AuthResponse(user.getId());
    }



    public void initiateUserVerificationEmail(String email) throws AirlineBookingSystemException {
        Optional<User> user = userService.getUserBy(email);
        if (user.isEmpty()) {
            throw new AirlineBookingSystemException("User not found");
        }
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo(user.get().getEmail());

        String verificationLink = "http://localhost:8080/api/v1/auth/verifyEmail?token="+user.get().getToken().getToken();
        emailRequest.setBody("Welcome to Syntax College Course Registration System. kindly verify your account. Your verification code is    " + user.get().getToken().getToken() + "    or click on this link    " + verificationLink);



        emailRequest.setSubject("College Course Reg PASSWORD REQUEST");
        mailService.sendSimpleMail(emailRequest);


    }


    public ValidateResponse verify(String token) throws AirlineBookingSystemException {
        Optional<VerificationToken> theToken = tokenRepository.findVerificationTokensByToken(token);
        if (theToken.isPresent() && theToken.get().getUser().isEnabled()){
            throw  new AirlineBookingSystemException("This account has already been verified, please, login");
        }
        String verificationResult = validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return new ValidateResponse("Email verified successfully. Now you can login to your account");
        } else {
       throw new AirlineBookingSystemException("Invalid verification token");}
    }

    @Override
    public Response forgotPassword(ForgotPasswordRequest forgotPasswordRequest) throws AirlineBookingSystemException {
        Optional<User> user = userService.getUserBy(forgotPasswordRequest.getEmail());
        if (user.isEmpty()) {
            throw new AirlineBookingSystemException("User not found");
        }
        user.get().setPassword(forgotPasswordRequest.getNewPassword());
        return new Response("Password changed successfully");
    }




    private String validateToken(String theToken) {
        Optional<VerificationToken> token = tokenRepository.findVerificationTokensByToken(theToken);
        if(token.isEmpty()){
            return "Invalid verification token";
        }
        User user = token.get().getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.get().getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0){
            tokenRepository.delete(token.get());
            return "Token already expired";
        }
        user.setEnabled(true);
        userService.saveUser(user);
        return "valid";
    }

}





