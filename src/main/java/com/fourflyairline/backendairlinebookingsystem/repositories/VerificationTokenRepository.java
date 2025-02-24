package com.fourflyairline.backendairlinebookingsystem.repositories;


import com.fourflyairline.backendairlinebookingsystem.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findVerificationTokensByToken(String token);
}
