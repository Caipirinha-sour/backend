package com.hackathon.api.volunteering.infrastructure.persistence.repositories;

import com.hackathon.api.volunteering.domain.models.entities.RegistrationCitizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationCitizenRepository extends JpaRepository<RegistrationCitizen, Long> {
}
