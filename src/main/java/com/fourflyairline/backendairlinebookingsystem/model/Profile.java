package com.fourflyairline.backendairlinebookingsystem.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String course;


    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToOne
    private ContactInformation contactInformation;
    private String profilePicture;
    @OneToOne
    private User user;
}
