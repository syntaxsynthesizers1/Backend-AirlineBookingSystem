package com.fourflyairline.backendairlinebookingsystem.repositories;

import com.fourflyairline.backendairlinebookingsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
