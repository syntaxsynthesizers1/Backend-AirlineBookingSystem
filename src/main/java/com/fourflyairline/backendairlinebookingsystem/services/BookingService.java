package com.fourflyairline.backendairlinebookingsystem.services;

import com.fourflyairline.backendairlinebookingsystem.dto.response.BookingResponse;
import com.fourflyairline.backendairlinebookingsystem.exceptions.AirlineBookingSystemException;
import com.fourflyairline.backendairlinebookingsystem.model.Booking;

public interface BookingService {
    Booking findBookingById (Long Id) throws AirlineBookingSystemException;
}
