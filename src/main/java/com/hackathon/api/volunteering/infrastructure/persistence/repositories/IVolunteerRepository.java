package com.hackathon.api.volunteering.infrastructure.persistence.repositories;

import com.hackathon.api.volunteering.domain.models.aggregates.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVolunteerRepository extends JpaRepository<Volunteer, Long> {
}
