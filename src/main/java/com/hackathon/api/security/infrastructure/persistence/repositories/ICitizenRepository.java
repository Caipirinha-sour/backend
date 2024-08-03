package com.hackathon.api.security.infrastructure.persistence.repositories;

import com.hackathon.api.security.domain.models.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitizenRepository extends JpaRepository<Citizen, Long> {
    Citizen findByEmail(String email);
    Citizen findByUsername(String username);
}
