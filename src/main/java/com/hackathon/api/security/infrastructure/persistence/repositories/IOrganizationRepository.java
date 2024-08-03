package com.hackathon.api.security.infrastructure.persistence.repositories;

import com.hackathon.api.security.domain.models.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findByEmail(String email);
    Organization findByUsername(String username);
}
