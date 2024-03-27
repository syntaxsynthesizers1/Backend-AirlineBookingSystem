package com.fourflyairline.backendairlinebookingsystem.repositories;


import com.fourflyairline.backendairlinebookingsystem.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
