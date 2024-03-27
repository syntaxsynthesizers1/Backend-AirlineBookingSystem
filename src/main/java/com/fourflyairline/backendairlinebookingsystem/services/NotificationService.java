package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.NotificationRequest;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;

public interface NotificationService {
    Response sendNotification (NotificationRequest noficationRequest);
}
