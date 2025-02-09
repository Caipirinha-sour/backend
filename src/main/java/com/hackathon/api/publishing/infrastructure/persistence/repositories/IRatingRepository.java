package com.hackathon.api.publishing.infrastructure.persistence.repositories;

import com.hackathon.api.publishing.domain.models.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRatingRepository extends JpaRepository<Rating, Long> {
}
