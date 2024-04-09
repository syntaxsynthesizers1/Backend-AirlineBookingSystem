package com.fourflyairline.backendairlinebookingsystem.controllers;
import com.fourflyairline.backendairlinebookingsystem.dto.request.ChangePasswordRequest;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;
import com.fourflyairline.backendairlinebookingsystem.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;


    @GetMapping("{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id)  {
        try {
            log.info("here");
            return ResponseEntity.ok(userService.getUserBy(id));
        }catch (AirlineBookingSystemException exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }
    @GetMapping("{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable String email)  {
        try {
            return ResponseEntity.ok(userService.getUserByEmail(email));
        }catch (AirlineBookingSystemException exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }
    @PostMapping("/change-password")
    public ResponseEntity<Response> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) throws AirlineBookingSystemException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(changePasswordRequest));
    }

    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(userService.getUsers(page, size));
    }


}
