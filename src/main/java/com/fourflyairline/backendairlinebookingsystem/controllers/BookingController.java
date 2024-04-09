package com.fourflyairline.backendairlinebookingsystem.controllers;

import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

private final BookingService bookingService;
    @GetMapping("{id}")
    public ResponseEntity<?> getBooking(@PathVariable Long id)  {
        try {
            return ResponseEntity.ok(bookingService.findBookingById(id));
        }catch (AirlineBookingSystemException exception){
            return ResponseEntity.badRequest().body(exception);
        }
    }
}



