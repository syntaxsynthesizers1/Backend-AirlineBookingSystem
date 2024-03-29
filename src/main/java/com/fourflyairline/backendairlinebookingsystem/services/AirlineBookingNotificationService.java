package com.fourflyairline.backendairlinebookingsystem.services;


import com.fourflyairline.backendairlinebookingsystem.dto.request.NotificationRequest;
import com.fourflyairline.backendairlinebookingsystem.globalDTO.Response;
import com.fourflyairline.backendairlinebookingsystem.mail.CollegeCourseEmailService;
import com.fourflyairline.backendairlinebookingsystem.mail.EmailRequest;
import com.fourflyairline.backendairlinebookingsystem.model.Notification;
import com.fourflyairline.backendairlinebookingsystem.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AirlineBookingNotificationService implements NotificationService {
    private final CollegeCourseEmailService mateEmailService;
    private final NotificationRepository notificationRepository;

    @Override
    public Response sendNotification(NotificationRequest noficationRequest) {
        Notification notification = new Notification();
        notification.setContent(noficationRequest.getContent());
        notification.setTimestamp(LocalDateTime.now());
        notification.setContent(noficationRequest.getContent());
        notificationRepository.save(notification);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setTo(noficationRequest.getRecipientEmail());
        emailRequest.setBody(noficationRequest.getContent());
        return new Response("Notification sent successfully");
    }
}
