package com.fourflyairline.backendairlinebookingsystem.repositories;


import com.fourflyairline.backendairlinebookingsystem.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
