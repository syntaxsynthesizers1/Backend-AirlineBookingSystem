package com.fourflyairline.backendairlinebookingsystem.exceptions;

public class AirlineBookingSystemException extends Throwable {
    public AirlineBookingSystemException(String message){
        super(message);
    }

    public AirlineBookingSystemException(Throwable throwable){
        super(throwable);
    }
}
