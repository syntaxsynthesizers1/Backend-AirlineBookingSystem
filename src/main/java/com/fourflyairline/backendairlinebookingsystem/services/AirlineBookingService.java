package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.BookingResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.model.Booking;
import com.fourflyairline.backendairlinebookingsystem.repositories.BookingRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AirlineBookingService implements BookingService{

    private final BookingRepository bookingRepository;
    @Override
    public Booking findBookingById(Long Id) throws AirlineBookingSystemException {
        return bookingRepository.findById(Id).orElseThrow(
                () -> new AirlineBookingSystemException(String.format("Booking with the id %d not found", Id))
        );

    }
}
