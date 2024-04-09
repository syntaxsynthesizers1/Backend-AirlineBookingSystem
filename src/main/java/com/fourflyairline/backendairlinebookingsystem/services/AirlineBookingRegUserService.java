package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.ChangePasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.CreateUserRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.response.UserResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;
import com.fourflyairline.backendairlinebookingsystem.model.User;
import com.fourflyairline.backendairlinebookingsystem.model.VerificationToken;
import com.fourflyairline.backendairlinebookingsystem.repositories.UserRepository;
import com.fourflyairline.backendairlinebookingsystem.repositories.VerificationTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.fourflyairline.backendairlinebookingsystem.model.Authority.USER;


@Service
@RequiredArgsConstructor
@Slf4j
public class AirlineBookingRegUserService implements UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository tokenRepository;

    private final NotificationService notificationService;


    @Override
    public User createUser(CreateUserRequest createUserRequest) throws AirlineBookingSystemException {
        // Check if the user already exists
        if (userRepository.findByEmail(createUserRequest.getEmail()).isPresent()) {
            throw new AirlineBookingSystemException("User with this email already exists");
        }

        // Encode the password before saving
        String encodedPassword = passwordEncoder.encode(createUserRequest.getPassword());

        // Create a new user
        User newUser = new User();
        newUser.setEmail(createUserRequest.getEmail());
        newUser.setPassword(encodedPassword);
        newUser.setFirstName(createUserRequest.getFirstName());
        newUser.setLastName(createUserRequest.getLastName());
        newUser.setGender(createUserRequest.getGender());
        newUser.setDob(createUserRequest.getDob());
        newUser.setNIC(createUserRequest.getNic());
        newUser.setPhoneNumber(createUserRequest.getPhoneNumber());
        String token =  UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token, newUser);
        tokenRepository.save(verificationToken);
       newUser.setToken(verificationToken);
        newUser.setAuthorities(List.of(USER));


        return userRepository.save(newUser);
    }

    @Override
    public Response changePassword(ChangePasswordRequest changePasswordRequest) throws AirlineBookingSystemException {
        Optional<User> user = getUserBy(changePasswordRequest.getEmail());
        if (user.isEmpty()) {
            throw new AirlineBookingSystemException("User not found");
        }
        if (!user.get().getPassword().equals(changePasswordRequest.getOldPassword()) ) {
            throw new AirlineBookingSystemException("Invalid Password");
        }
        user.get().setPassword(changePasswordRequest.getNewPassword());

        return new Response("Password Changed Successfully");
    }

    @Override
    public User saveUser (User user) {
        return userRepository.save(user);
    }



    @Override
    public User getUserById(Long id) throws AirlineBookingSystemException {
        return userRepository.findById(id).orElseThrow(
                ()-> new AirlineBookingSystemException(String.format("user with id %d not found", id))
        );
    }
    @Override
    public UserResponse getUserBy(Long id) throws AirlineBookingSystemException {
        User user = getUserById(id);
        return modelMapper.map(user, UserResponse.class);
    }
    @Override
    public UserResponse getUserByEmail(String email) throws AirlineBookingSystemException {
        User user =  userRepository.findByEmail(email).orElseThrow(
                ()-> new AirlineBookingSystemException(String.format("user with id %d not found", email))
        );
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> users = userPage.getContent();
        log.info("users:: {}", users);
        return users.stream()
                    .map(user->modelMapper.map(user, UserResponse.class))
                    .toList();

    }

    @Override
    public Optional<User> getUserBy(String email) {

        return userRepository.findByEmail(email);
    }

    private void updatePassword(String email, String newPassword) throws AirlineBookingSystemException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new AirlineBookingSystemException("User not found with email: " + email));


        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }







}
