package com.fourflyairline.backendairlinebookingsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class BookingResponse {
    private Double amount;
    private Long userId;
    private Long flightId;
    private LocalDateTime bookedDate;
    private String status;
    private Long count;
    private String seatClass;
}
