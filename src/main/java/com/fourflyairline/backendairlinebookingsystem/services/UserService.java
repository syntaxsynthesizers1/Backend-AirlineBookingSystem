package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.ChangePasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.request.CreateUserRequest;
import com.fourflyairline.backendairlinebookingsystem.dto.response.UserResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.CollegeCourseRegistrationException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;
import com.fourflyairline.backendairlinebookingsystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    User getUserById(Long id) throws CollegeCourseRegistrationException;

    UserResponse getUserBy(Long id) throws CollegeCourseRegistrationException;

    List<UserResponse> getUsers(int page, int size);

    Optional<User> getUserBy(String username);
    User createUser (CreateUserRequest createUserRequest) throws CollegeCourseRegistrationException;
    User saveUser (User user);
    Response changePassword (ChangePasswordRequest changePasswordRequest) throws CollegeCourseRegistrationException;


}
